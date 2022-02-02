package com.becaJavaJeferson.controllers;

import com.becaJavaJeferson.dtos.requests.PostLocatarioRequest;
import com.becaJavaJeferson.dtos.responses.PostLocatarioResponse;
import com.becaJavaJeferson.model.Locatario;
import com.becaJavaJeferson.services.LocatarioService;
import com.becaJavaJeferson.services.serviceImp.LocatarioServicesImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/locatario")
public class LocatarioController {

    // 0:35:41

    @Autowired
    private LocatarioServicesImp locatarioService;

    //CREATE
    @PostMapping
    public ResponseEntity<PostLocatarioResponse> criar(@RequestBody PostLocatarioRequest postLocatarioRequest){
        PostLocatarioResponse postLocatarioResponse = locatarioService.criar(postLocatarioRequest);

        return ResponseEntity.created(null).body(postLocatarioResponse);
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
