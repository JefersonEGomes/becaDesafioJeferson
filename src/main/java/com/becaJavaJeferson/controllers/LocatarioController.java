package com.becaJavaJeferson.controllers;

import com.becaJavaJeferson.model.Locatario;
import com.becaJavaJeferson.services.LocatarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/locatario")
public class LocatarioController {

    // 1:17:16
    @Autowired
    private LocatarioServices locatarioServices;
    //CREATE
    @PostMapping
    public ResponseEntity<Locatario> criar(@RequestBody Locatario locatario){
        Locatario criarLocatario = locatarioServices.criar(locatario);

        return ResponseEntity.created(null).body(criarLocatario);
    }

    //READ
    @GetMapping
    public ResponseEntity<List<Locatario>> listar(){
        List<Locatario> listaLocatario = locatarioServices.listar();

        return ResponseEntity.ok(listaLocatario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Locatario> obter(@PathVariable Integer id){
        Locatario locatarioObtido = locatarioServices.obter(id);

        return ResponseEntity.ok(locatarioObtido);
    }

    //UPDATE
    @PatchMapping("/{id}")
    public ResponseEntity<Locatario> atualizar(@RequestBody Locatario locatario, @PathVariable Integer id){
        Locatario atualizarLocatario = locatarioServices.atualizar(locatario, id);

        return ResponseEntity.ok(atualizarLocatario);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Integer id){
        locatarioServices.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
