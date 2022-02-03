package com.becaJavaJeferson.controllers;

import com.becaJavaJeferson.dtos.requests.posts.PostLocacaoRequest;
import com.becaJavaJeferson.dtos.responses.gets.ids.GetLocacaoResponse;
import com.becaJavaJeferson.dtos.responses.posts.PostLocacaoResponse;
import com.becaJavaJeferson.model.Locacao;
import com.becaJavaJeferson.services.serviceImp.LocacaoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locacao")
public class LocacaoController {

    @Autowired
    private LocacaoServiceImp locacaoService;

    //CREATE
    @PostMapping
    public ResponseEntity<PostLocacaoResponse> criar(@RequestBody PostLocacaoRequest postLocacaoRequest) {
        PostLocacaoResponse postLocacaoResponse = locacaoService.criar(postLocacaoRequest);

        return ResponseEntity.created(null).body(postLocacaoResponse);
    }

    //READ
    @GetMapping
    public ResponseEntity<List<Locacao>> listar(){
        List<Locacao> listaLocacoes = locacaoService.listar();

        return ResponseEntity.ok(listaLocacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetLocacaoResponse> obter(@PathVariable Integer id){
        GetLocacaoResponse locacaoObtida = locacaoService.obter(id);

        return ResponseEntity.ok(locacaoObtida);
    }

    //UPDATE
//    @PatchMapping("/{id}")
//    public ResponseEntity<Locacao> atualizar(@RequestBody Locacao locacao,@PathVariable Integer id){
//        Locacao locacaoAtualizada = locacaoService.atualizar(locacao, id);
//
//        return ResponseEntity.ok(locacaoAtualizada);
//    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Integer id){
        locacaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
