package com.becaJavaJeferson.controllers;

import com.becaJavaJeferson.model.Locacao;
import com.becaJavaJeferson.services.LocacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locacao")
public class LocacaoController {

    @Autowired
    private LocacaoService locacaoService;

    //CREATE
    @PostMapping
    public ResponseEntity<Locacao> criar(@RequestBody Locacao locacao) {
        Locacao criarLocacao = locacaoService.criar(locacao);

        return ResponseEntity.created(null).body(criarLocacao);
    }

    //READ
    @GetMapping
    public ResponseEntity<List<Locacao>> listar(){
        List<Locacao> listaLocacoes = locacaoService.listar();

        return ResponseEntity.ok(listaLocacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Locacao> obter(@PathVariable Integer id){
        Locacao locacaoObtida = locacaoService.obter(id);

        return ResponseEntity.ok(locacaoObtida);
    }

    //UPDATE
    @PatchMapping("/{id}")
    public ResponseEntity<Locacao> atualizar(@RequestBody Locacao locacao,@PathVariable Integer id){
        Locacao locacaoAtualizada = locacaoService.atualizar(locacao, id);

        return ResponseEntity.ok(locacaoAtualizada);
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Integer id){
        locacaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
