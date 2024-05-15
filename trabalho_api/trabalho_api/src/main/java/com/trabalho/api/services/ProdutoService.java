package com.trabalho.api.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalho.api.dtos.ProdutoDTO;
import com.trabalho.api.entity.Produto;
import com.trabalho.api.entity.Tipo;
import com.trabalho.api.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<ProdutoDTO> buscarTodos() {
        return repository.findAll().stream()
                .map(p -> new ProdutoDTO(p.getId(), p.getNome(),
                        p.getDescricao(), p.getPreco(), p.getTipo()))
                .toList();
    }

    public Optional<ProdutoDTO> buscarPorId(Long id) {
        Optional<Produto> produto = repository.findById(id);

        if (produto.isPresent()) {
            return Optional.of(produto.get().toDTO());
        }
        return Optional.empty();
    }

    public List<ProdutoDTO> buscarPorNome(String nome) {
        return repository.findByNomeContaining(nome).stream().map(p -> new ProdutoDTO(p.getId(), p.getNome(), p.getDescricao(), p.getPreco(), p.getTipo())).collect(Collectors.toList());
    }

    public List<ProdutoDTO> buscarPorPreco(Double menor, Double maior) {
        return repository.findByPrecoBetween(BigDecimal.valueOf(menor), BigDecimal.valueOf(maior)).stream().map(p -> new ProdutoDTO(p.getId(), p.getNome(), p.getDescricao(), p.getPreco(), p.getTipo())).collect(Collectors.toList());
    }

    public List<ProdutoDTO> buscarPorTipo(Tipo tipo) {
        return repository.findByTipo(tipo).stream().map(p -> new ProdutoDTO(p.getId(), p.getNome(), p.getDescricao(), p.getPreco(), p.getTipo())).collect(Collectors.toList());
    }

    public ProdutoDTO cadastrar(ProdutoDTO produto) {
        Produto produtoEntity = produto.toEntity();
        repository.save(produtoEntity);
        return produtoEntity.toDTO();
    }

    public Optional<ProdutoDTO> alterar(Long id, ProdutoDTO produto) {
        Produto produtoEntity = produto.toEntity();

        if (repository.existsById(id)) {
            produtoEntity.setId(id);
            repository.save(produtoEntity);
            return Optional.of(produtoEntity.toDTO());
        }
        return Optional.empty();
    }

    public Boolean deletar(Long id) {

        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }
}