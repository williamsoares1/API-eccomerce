package com.trabalho.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.trabalho.api.dtos.ProdutoDTO;
import com.trabalho.api.services.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

	@Autowired
	private ProdutoService service;

	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> buscarTodosOsProdutos() {
		return ResponseEntity.ok(service.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDTO> buscarProdutoPorId(@PathVariable Long id) {
		return ResponseEntity.of(service.buscarPorId(id));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ProdutoDTO> cadastrar(@Valid @RequestBody ProdutoDTO produto) {
		return ResponseEntity.ok(service.cadastrar(produto));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProdutoDTO> AlterarProduto(@Valid @PathVariable Long id, @RequestBody ProdutoDTO produtoAlterado) {
		return ResponseEntity.of(service.alterar(id, produtoAlterado));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deletarProduto(@PathVariable Long id) {
		return ResponseEntity.of(service.deletar(id));
	}
}