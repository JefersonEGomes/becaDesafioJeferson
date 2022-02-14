package com.becaJavaJeferson.controllers;

import com.becaJavaJeferson.dtos.requests.patch.PatchLocatarioRequest;
import com.becaJavaJeferson.dtos.requests.posts.PostLocatarioRequest;
import com.becaJavaJeferson.dtos.responses.gets.ids.GetLocatarioResponse;
import com.becaJavaJeferson.dtos.responses.gets.lists.GetLocatarioListResponse;
import com.becaJavaJeferson.dtos.responses.patch.PatchLocatarioResponse;
import com.becaJavaJeferson.dtos.responses.posts.PostLocatarioResponse;
import com.becaJavaJeferson.services.serviceImp.LocatarioServicesImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/locatario")
public class LocatarioController {

    @Autowired
    private LocatarioServicesImp locatarioService;

    //CREATE
    @PostMapping
    public ResponseEntity<PostLocatarioResponse> criar(@RequestBody @Valid PostLocatarioRequest postLocatarioRequest){
        PostLocatarioResponse postLocatarioResponse = locatarioService.criar(postLocatarioRequest);

        return ResponseEntity.created(null).body(postLocatarioResponse);
    }

    //READ
    @GetMapping
    public ResponseEntity<List<GetLocatarioListResponse>> listar(){
        List<GetLocatarioListResponse> listaLocatario = locatarioService.listar();

        return ResponseEntity.ok(listaLocatario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetLocatarioResponse> obter(@PathVariable Integer id){
        GetLocatarioResponse getLocatarioResponse = locatarioService.obter(id);

        return ResponseEntity.ok(getLocatarioResponse);
    }

    //UPDATE
    @PatchMapping("/{id}")
    public ResponseEntity<PatchLocatarioResponse> atualizar(@RequestBody @Valid PatchLocatarioRequest patchLocatarioRequest, @PathVariable Integer id){
        PatchLocatarioResponse atualizarLocatario = locatarioService.atualizar(patchLocatarioRequest, id);

        return ResponseEntity.ok(atualizarLocatario);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Integer id){
        locatarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
