package com.trabalho.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalho.api.dtos.ProdutoDTO;
import com.trabalho.api.entity.Produto;
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

    public Optional<Boolean> deletar(Long id) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }

        repository.deleteById(id);
        return Optional.of(true);
    }
}