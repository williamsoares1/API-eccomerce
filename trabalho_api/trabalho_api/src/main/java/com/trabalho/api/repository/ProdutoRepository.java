package com.trabalho.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalho.api.entity.Produto;
import com.trabalho.api.entity.Tipo;

import java.util.List;
import java.math.BigDecimal;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    List<Produto> findByNomeContaining(String nome);
    List<Produto> findByTipo(Tipo tipo);
    List<Produto> findByPrecoBetween(BigDecimal menor, BigDecimal maior);
}
