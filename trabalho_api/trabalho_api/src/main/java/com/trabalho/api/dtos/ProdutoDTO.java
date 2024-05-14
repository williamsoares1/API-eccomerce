package com.trabalho.api.dtos;

import java.math.BigDecimal;

import com.trabalho.api.entity.Produto;
import com.trabalho.api.entity.Tipo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record ProdutoDTO(
        Long id,
        @NotBlank String nome,
        @NotBlank String descricao,
        @NotNull @PositiveOrZero BigDecimal preco,
        @NotNull Tipo tipo) {

    public Produto toEntity() {
        return new Produto(this.id, this.nome, this.descricao, this.preco, this.tipo);
    }

}
