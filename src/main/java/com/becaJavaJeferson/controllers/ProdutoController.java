package com.becaJavaJeferson.controllers;

import com.becaJavaJeferson.model.Produto;
import com.becaJavaJeferson.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    //CREATE
    @PostMapping
    public ResponseEntity<Produto> criar(@RequestBody Produto produto){
        Produto produtoCriado = produtoService.criar(produto);

        return ResponseEntity.created(null).body(produtoCriado);

    }

    // READ
    @GetMapping
    public ResponseEntity<List<Produto>> listar(){
        List<Produto> listaProdutos = produtoService.listar();
        return ResponseEntity.ok(listaProdutos);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> obter(@PathVariable Integer id){
        Produto produtoObtido = produtoService.obter(id);

        return ResponseEntity.ok(produtoObtido);
    }

    // UPDATE
    @PatchMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@RequestBody Produto produto, @PathVariable Integer id){
        Produto produtoAtualizado = produtoService.atualizar(produto, id);

        return ResponseEntity.ok(produtoAtualizado);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Integer id){
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();

    }
}
