package com.becaJavaJeferson.controllers;

import com.becaJavaJeferson.model.Locador;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/locador")
public class LocadorController {

    // CRUD
    @PostMapping
    public ResponseEntity<Locador> criarLocador(@RequestBody Locador locador){

        Random randomId = new Random();
        locador.setIdLocador(randomId.nextInt(1000));

        return ResponseEntity.created(null).body(locador);
    }

    // READ
    public class listaLocador{

    }

    // UPDATE
    public class atualizarLocador{

    }

    // DELETE
    public class deletarLocadore{

    }
}
