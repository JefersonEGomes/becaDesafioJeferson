package com.becaJavaJeferson.services;

import com.becaJavaJeferson.model.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Random;

public class ProdutoServices {

    @PostMapping
    public ResponseEntity<Produto> criar(@RequestBody Produto produto){

        Random randomId = new Random();
        produto.setId(randomId.nextInt(1000));

        if( produto.getNome().length() <= 3){
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.created(null).body(produto);

    }
}
