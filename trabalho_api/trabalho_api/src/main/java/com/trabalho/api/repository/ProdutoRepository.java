package com.trabalho.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalho.api.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
