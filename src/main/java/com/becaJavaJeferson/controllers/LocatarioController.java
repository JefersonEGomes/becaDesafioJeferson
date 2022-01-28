package com.becaJavaJeferson.controllers;

import com.becaJavaJeferson.model.Locatario;
import com.becaJavaJeferson.services.LocatarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/locatario")
public class LocatarioController {


    @Autowired
    private LocatarioService locatarioService;

    //CREATE
    @PostMapping
    public ResponseEntity<Locatario> criar(@RequestBody Locatario locatario){
        Locatario criarLocatario = locatarioService.criar(locatario);

        return ResponseEntity.created(null).body(criarLocatario);
    }

    //READ
    @GetMapping
    public ResponseEntity<List<Locatario>> listar(){
        List<Locatario> listaLocatario = locatarioService.listar();

        return ResponseEntity.ok(listaLocatario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Locatario> obter(@PathVariable Integer id){
        Locatario locatarioObtido = locatarioService.obter(id);

        return ResponseEntity.ok(locatarioObtido);
    }

    //UPDATE
    @PatchMapping("/{id}")
    public ResponseEntity<Locatario> atualizar(@RequestBody Locatario locatario, @PathVariable Integer id){
        Locatario atualizarLocatario = locatarioService.atualizar(locatario, id);

        return ResponseEntity.ok(atualizarLocatario);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Integer id){
        locatarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
