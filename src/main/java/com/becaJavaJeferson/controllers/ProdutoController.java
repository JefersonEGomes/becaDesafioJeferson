package com.becaJavaJeferson.controllers;

import com.becaJavaJeferson.model.Locador;
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
    public ResponseEntity<Produto> criar(@RequestBody Produto produto){

        Random randomId = new Random();
        produto.setId(randomId.nextInt(1000));

        if( produto.getNome().length() <= 3){
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.created(null).body(produto);

    }

    // READ
    @GetMapping
    public ResponseEntity<List<Produto>> listar(){
        // Instancia para Teste
        Locador locador1 = new Locador();
        locador1.setId(1);
        locador1.setNome("João");
        locador1.setIdade(22);
        locador1.setCpf(12345678900L);
        locador1.setTelefone(81945678900L);

        Locador locador2 = new Locador();
        locador2.setId(2);
        locador2.setNome("Roberto");
        locador2.setIdade(34);
        locador2.setCpf(90087654321L);
        locador2.setTelefone(81909876543L);

        Locador locador3 = new Locador();
        locador1.setId(3);
        locador1.setNome("Elias");
        locador1.setIdade(52);
        locador1.setCpf(56912300000L);
        locador1.setTelefone(81912345678L);

        Produto prod1 = new Produto();
        prod1.setId(1);
        prod1.setNome("Controle Xbox");
        prod1.setCategoria("Tecnologia");
        prod1.setPreco(250.00);
        prod1.setId(58);
        prod1.setLocador(locador1);


        Produto prod2 = new Produto();
        prod2.setId(2);
        prod2.setNome("Bicicleta");
        prod2.setCategoria("Veículo");
        prod2.setPreco(320.00);
        prod2.setLocador(locador2);

        Produto prod3 = new Produto();
        prod3.setId(3);
        prod3.setNome("Bola de Futebol");
        prod3.setCategoria("Esportes");
        prod3.setPreco(50.00);
        prod3.setLocador(locador3);


        return ResponseEntity.ok(List.of(
                prod1,
                prod2,
                prod3
        ));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> obter(@PathVariable Integer id){
        // Instancia para Teste
        Locador locador1 = new Locador();
        locador1.setId(1);
        locador1.setNome("João");
        locador1.setIdade(22);
        locador1.setCpf(12345678900L);
        locador1.setTelefone(81945678900L);

        Produto prod1 = new Produto();
        prod1.setId(id);
        prod1.setNome("Controle Xbox");
        prod1.setCategoria("Tecnologia");
        prod1.setPreco(250.00);
        prod1.setLocador(locador1);
        prod1.setId(58);

        return ResponseEntity.ok(prod1);
    }

    // UPDATE
    @PatchMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@RequestBody Produto produto, @PathVariable Integer id){
        produto.setId(id);

        return ResponseEntity.ok(produto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Integer id){

        return ResponseEntity.noContent().build();

    }
}
