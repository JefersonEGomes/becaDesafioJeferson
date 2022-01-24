package com.becaJavaJeferson.controllers;

import com.becaJavaJeferson.model.Locacao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

@RestController
@RequestMapping("/locacao")
public class LocacaoController {

    //CREATE
    @PostMapping
    public ResponseEntity<Locacao> criar(@RequestBody Locacao locacao) {
        Random id = new Random();
        locacao.setIdLocacao(id.nextInt(1000));

        return ResponseEntity.created(null).body(locacao);
    }

    //READ
    @GetMapping
    public ResponseEntity<List<Locacao>> listar(){
        Locacao locacao1 = new Locacao();
        Locacao locacao2 = new Locacao();

        locacao1.setIdLocacao(1);
        locacao1.setIdLocador(2);
        locacao1.setIdLocatario(3);
        locacao1.setIdProduto(5);
        locacao1.setDataLocacao("05/01/2022");
        locacao1.setDataDevolve("14/03/2022");

        locacao2.setIdLocacao(2);
        locacao2.setIdLocador(1);
        locacao2.setIdLocatario(5);
        locacao2.setIdProduto(3);
        locacao2.setDataLocacao("01/05/2022");
        locacao2.setDataDevolve("03/07/2022");

        return ResponseEntity.ok(List.of(
                locacao1,
                locacao2
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Locacao> obter(@PathVariable Integer id){
        Locacao locacao3 = new Locacao();

        locacao3.setIdLocacao(id);
        locacao3.setIdLocador(2);
        locacao3.setIdLocatario(3);
        locacao3.setIdProduto(5);
        locacao3.setDataLocacao("08/02/2022");
        locacao3.setDataDevolve("16/04/2022");

        return ResponseEntity.ok(locacao3);
    }

    //UPDATE
    @PatchMapping("/{id}")
    public ResponseEntity<Locacao> atualizar(@RequestBody Locacao locacao,@PathVariable Integer id){
        locacao.setIdLocacao(id);

        return ResponseEntity.ok(locacao);
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Integer id){

        return ResponseEntity.noContent().build();
    }

}
