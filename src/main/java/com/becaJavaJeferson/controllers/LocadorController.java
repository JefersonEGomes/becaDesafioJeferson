package com.becaJavaJeferson.controllers;

import com.becaJavaJeferson.model.Locador;
import com.becaJavaJeferson.services.LocadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locador")
public class LocadorController {

    @Autowired
    private LocadorService locadorService;

    // CREATE
    @PostMapping
    public ResponseEntity<Locador> criar(@RequestBody Locador locador){
        Locador criarLocador = locadorService.criar(locador);


        return ResponseEntity.created(null).body(criarLocador);
    }

    // READ
    @GetMapping
    public ResponseEntity<List<Locador>> listar(){
        List<Locador> listaLocadores = locadorService.listar();

        return ResponseEntity.ok(listaLocadores);
    }

    public ResponseEntity<Locador> obter(@PathVariable Integer id){
        Locador obterLocador = locadorService.obter(id);

        return ResponseEntity.ok(obterLocador);
    }

    // UPDATE
    @PatchMapping("/{id}")
    public ResponseEntity<Locador> atualizar(@RequestBody Locador locador, @PathVariable Integer id){
        Locador atualizarLocador = locadorService.atualizar(locador, id);

        return ResponseEntity.ok(atualizarLocador);

    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Integer id){
        locadorService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
