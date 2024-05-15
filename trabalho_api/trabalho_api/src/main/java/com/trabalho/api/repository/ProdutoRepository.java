package com.trabalho.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalho.api.entity.Produto;
import java.util.List;
import java.math.BigDecimal;



public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    List<Produto> findByNomeContaining(String nome);
    List<Produto> findByDescricaoContaining(String desc);
    List<Produto> findByPrecoBetween(BigDecimal menor, BigDecimal maior);
}
