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
    public ResponseEntity<Locatario> criarLocatario(@RequestBody Locatario locatario){
        Random randomId = new Random();
        locatario.setIdLocatario(randomId.nextInt(1000));

        return ResponseEntity.created(null).body(locatario);
    }

    //READ
    @GetMapping
    public ResponseEntity<List<Locatario>> listaLocatario(){
        Locatario locatario1 = new Locatario();
        Locatario locatario2 = new Locatario();

        locatario1.setIdLocatario(1);
        locatario1.setNome("Jeferson");
        locatario1.setCpf(11111111111L);
        locatario1.setIdade(22);
        locatario1.setTelefone(819999999L);
        locatario1.setIdPessoa(1);

        locatario2.setIdLocatario(2);
        locatario2.setNome("Jackson");
        locatario2.setCpf(22222222222L);
        locatario2.setIdade(33);
        locatario2.setTelefone(81922222222L);
        locatario2.setIdPessoa(2);

        return ResponseEntity.ok(List.of(
           locatario1,
           locatario2
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Locatario> obterLocatario(@PathVariable Integer id){
        Locatario locatario3 = new Locatario();

        locatario3.setIdLocatario(id);
        locatario3.setNome("James");
        locatario3.setCpf(33333333333L);
        locatario3.setIdade(44);
        locatario3.setTelefone(81933333333L);
        locatario3.setIdPessoa(5);

        return ResponseEntity.ok(locatario3);
    }

    //UPDATE
    @PatchMapping("/{id}")
    public ResponseEntity<Locatario> atualizarLocatario(@RequestBody Locatario locatario, @PathVariable Integer id){
        locatario.setIdLocatario(id);

        return ResponseEntity.ok(locatario);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarLocatario(@PathVariable Integer id){
        return ResponseEntity.noContent().build();
    }

}
