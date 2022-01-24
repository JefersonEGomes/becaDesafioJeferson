package com.becaJavaJeferson.controllers;

import com.becaJavaJeferson.model.Locador;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/locador")
public class LocadorController {

    // CREATE
    @PostMapping
    public ResponseEntity<Locador> criar(@RequestBody Locador locador){

        Random randomId = new Random();
        locador.setId(randomId.nextInt(1000));

        return ResponseEntity.created(null).body(locador);
    }

    // READ
    @GetMapping
    public ResponseEntity<List<Locador>> listar(){
        Locador locador1 = new Locador();
        Locador locador2 = new Locador();

        locador1.setId(1);
        locador1.setNome("Jeferson");
        locador1.setCpf(11111111111L);
        locador1.setIdade(22);
        locador1.setTelefone(819999999L);
        locador1.setId(1);

        locador2.setId(2);
        locador2.setNome("Jeferson");
        locador2.setCpf(22222222222L);
        locador2.setIdade(33);
        locador2.setTelefone(81922222222L);
        locador2.setId(2);

        return ResponseEntity.ok(List.of(
                locador1,
                locador2
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Locador> obter(@PathVariable Integer id){
        Locador locador3 = new Locador();
        locador3.setId(id);
        locador3.setId(3);
        locador3.setNome("Magnus");
        locador3.setIdade(19);
        locador3.setTelefone(81955555555L);
        locador3.setCpf(12345678900L);

        return ResponseEntity.ok(locador3);
    }

    // UPDATE
    @PatchMapping("/{id}")
    public ResponseEntity<Locador> atualizar(@RequestBody Locador locador, @PathVariable Integer id){
        locador.setId(id);

        return ResponseEntity.ok(locador);

    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Integer id){

        return ResponseEntity.noContent().build();
    }
}
