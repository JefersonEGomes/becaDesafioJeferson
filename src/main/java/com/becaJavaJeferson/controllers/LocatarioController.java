package com.becaJavaJeferson.controllers;

import com.becaJavaJeferson.model.Locatario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;


@RestController
@RequestMapping("/locatario")
public class LocatarioController {

    //CREATE
    @PostMapping
    public ResponseEntity<Locatario> criar(@RequestBody Locatario locatario){
        Random randomId = new Random();
        locatario.setId(randomId.nextInt(1000));

        return ResponseEntity.created(null).body(locatario);
    }

    //READ
    @GetMapping
    public ResponseEntity<List<Locatario>> listar(){
        Locatario locatario1 = new Locatario();
        Locatario locatario2 = new Locatario();

        locatario1.setId(1);
        locatario1.setNome("Jeferson");
        locatario1.setCpf(11111111111L);
        locatario1.setIdade(22);
        locatario1.setTelefone(819999999L);
        locatario1.setId(1);

        locatario2.setId(2);
        locatario2.setNome("Jackson");
        locatario2.setCpf(22222222222L);
        locatario2.setIdade(33);
        locatario2.setTelefone(81922222222L);
        locatario2.setId(2);

        return ResponseEntity.ok(List.of(
           locatario1,
           locatario2
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Locatario> obter(@PathVariable Integer id){
        Locatario locatario3 = new Locatario();

        locatario3.setId(id);
        locatario3.setNome("James");
        locatario3.setCpf(33333333333L);
        locatario3.setIdade(44);
        locatario3.setTelefone(81933333333L);
        locatario3.setId(5);

        return ResponseEntity.ok(locatario3);
    }

    //UPDATE
    @PatchMapping("/{id}")
    public ResponseEntity<Locatario> atualizar(@RequestBody Locatario locatario, @PathVariable Integer id){
        locatario.setId(id);

        return ResponseEntity.ok(locatario);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Integer id){
        return ResponseEntity.noContent().build();
    }

}
