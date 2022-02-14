package com.becaJavaJeferson.controllers;

import com.becaJavaJeferson.dtos.requests.patch.PatchLocadorRequest;
import com.becaJavaJeferson.dtos.requests.posts.PostLocadorRequest;
import com.becaJavaJeferson.dtos.responses.gets.ids.GetLocadorResponse;
import com.becaJavaJeferson.dtos.responses.gets.lists.GetLocadorListResponse;
import com.becaJavaJeferson.dtos.responses.patch.PatchLocadorResponse;
import com.becaJavaJeferson.dtos.responses.posts.PostLocadorResponse;
import com.becaJavaJeferson.services.serviceImp.LocadorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/locador")
public class LocadorController {

    @Autowired
    private LocadorServiceImp locadorService;

    // CREATE
    @PostMapping
    public ResponseEntity<PostLocadorResponse> criar(@RequestBody @Valid PostLocadorRequest postLocadorRequest){
        PostLocadorResponse postLocadorResponse = locadorService.criar(postLocadorRequest);

        return ResponseEntity.created(null).body(postLocadorResponse);
    }

    // READ
    @GetMapping
    public ResponseEntity<List<GetLocadorListResponse>> listar(){
        List<GetLocadorListResponse> listaLocadores = locadorService.listar();

        return ResponseEntity.ok(listaLocadores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetLocadorResponse> obter(@PathVariable Integer id){
        GetLocadorResponse getLocadorResponse = locadorService.obter(id);

        return ResponseEntity.ok(getLocadorResponse);
    }

//    // UPDATE
    @PatchMapping("/{id}")
    public ResponseEntity<PatchLocadorResponse> atualizar(@RequestBody @Valid PatchLocadorRequest patchLocadorRequest, @PathVariable Integer id){
        PatchLocadorResponse atualizarLocador = locadorService.atualizar(patchLocadorRequest, id);

        return ResponseEntity.ok(atualizarLocador);

    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Integer id){
        locadorService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
