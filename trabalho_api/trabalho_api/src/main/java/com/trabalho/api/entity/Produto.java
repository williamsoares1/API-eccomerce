package com.trabalho.api.entity;

import java.math.BigDecimal;

import com.trabalho.api.dtos.ProdutoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Restaurante")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long id;
    private String nome;
    private String descricao;
    @Column(name = "preco_REAIS")
    private BigDecimal preco;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    public Produto(){}

    public Produto(Long id, String nome, String descricao, BigDecimal preco, Tipo tipo){
        super();
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public ProdutoDTO toDTO(){
        return new ProdutoDTO(this.id, this.nome, this.descricao, this.preco, this.tipo);
    }
}
