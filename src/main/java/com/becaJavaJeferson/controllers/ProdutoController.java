package com.becaJavaJeferson.controllers;

import com.becaJavaJeferson.model.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    //CREATE
    @PostMapping
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto){

        Random randomId = new Random();
        produto.setIdProduto(randomId.nextInt(1000));

        if( produto.getNome().length() <= 3){
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.created(null).body(produto);

    }

    // READ
    @GetMapping
    public ResponseEntity<List<Produto>> listarProduto(){
        Produto prod1 = new Produto();
        prod1.setIdProduto(1);
        prod1.setNome("Controle Xbox");
        prod1.setCategoria("Tecnologia");
        prod1.setPreco(250.00);
        prod1.setIdLocador(58);


        Produto prod2 = new Produto();
        prod2.setIdProduto(2);
        prod2.setNome("Bicicleta");
        prod2.setCategoria("Veículo");
        prod2.setPreco(320.00);
        prod2.setIdLocador(27);

        Produto prod3 = new Produto();
        prod3.setIdProduto(3);
        prod3.setNome("Bola de Futebol");
        prod3.setCategoria("Esportes");
        prod3.setPreco(50.00);
        prod3.setIdLocador(10);


        return ResponseEntity.ok(List.of(
                prod1,
                prod2,
                prod3
        ));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> obterProduto(@PathVariable Integer id){
        Produto prod1 = new Produto();
        prod1.setIdProduto(id);
        prod1.setNome("Controle Xbox");
        prod1.setCategoria("Tecnologia");
        prod1.setPreco(250.00);
        prod1.setIdLocador(58);

        return ResponseEntity.ok(prod1);
    }

    // UPDATE
    @PatchMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@RequestBody Produto produto, @PathVariable Integer id){
        produto.setIdProduto(id);

        return ResponseEntity.ok(produto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarProduto(@PathVariable Integer id){

        return ResponseEntity.noContent().build();

    }
}
