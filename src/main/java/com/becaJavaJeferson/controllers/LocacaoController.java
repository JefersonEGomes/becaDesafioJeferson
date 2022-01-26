package com.becaJavaJeferson.controllers;

import com.becaJavaJeferson.model.Locacao;
import com.becaJavaJeferson.model.Locador;
import com.becaJavaJeferson.model.Locatario;
import com.becaJavaJeferson.model.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/locacao")
public class LocacaoController {


    //CREATE
    @PostMapping
    public ResponseEntity<Locacao> criar(@RequestBody Locacao locacao) {
        Random id = new Random();
        locacao.setId(id.nextInt(1000));

        return ResponseEntity.created(null).body(locacao);
    }

    //READ
    @GetMapping
    public ResponseEntity<List<Locacao>> listar(){
        // Instancia para Teste

        Locador locador1 = new Locador();
        locador1.setId(1);
        locador1.setNome("João");
        locador1.setIdade(22);
        locador1.setCpf(12345678900L);
        locador1.setTelefone(81945678900L);

        Locatario locatario1 = new Locatario();
        locatario1.setId(2);
        locatario1.setNome("Rodrigo");
        locatario1.setIdade(25);
        locatario1.setCpf(12345678900L);
        locatario1.setTelefone(81945678900L);

        Produto produto1 = new Produto();
        produto1.setId(3);
        produto1.setNome("Controle Xbox");
        produto1.setCategoria("Tecnologia");
        produto1.setPreco(250.00);
        produto1.setLocador(locador1);
        produto1.setId(58);

        Locacao locacao1 = new Locacao();

        locacao1.setProduto(produto1);
        locacao1.setId(2);
        locacao1.setLocador(locador1);
        locacao1.setLocatario(locatario1);
        locacao1.setDataAluguel(LocalDate.of(2022,8,10));
        locacao1.setDataDevolve(LocalDate.of(2022,5,23));

        return ResponseEntity.ok(List.of(
                locacao1
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Locacao> obter(@PathVariable Integer id){
        // Instancia para teste
        Locador locador3 = new Locador();
        locador3.setId(3);
        locador3.setNome("Jorge");
        locador3.setIdade(35);
        locador3.setCpf(12345678900L);
        locador3.setTelefone(81945678900L);

        Locatario locatario3 = new Locatario();
        locatario3.setId(3);
        locatario3.setNome("Richarlison");
        locatario3.setIdade(25);
        locatario3.setCpf(12365478900L);
        locatario3.setTelefone(81912378900L);

        Produto produto3 = new Produto();
        produto3.setId(3);
        produto3.setNome("Controle Xbox");
        produto3.setCategoria("Tecnologia");
        produto3.setPreco(250.00);
        produto3.setLocador(locador3);
        produto3.setId(58);


        Locacao locacao3 = new Locacao();

        locacao3.setProduto(produto3);
        locacao3.setId(2);
        locacao3.setLocador(locador3);
        locacao3.setLocatario(locatario3);
        locacao3.setDataAluguel(LocalDate.of(2022,5,22));
        locacao3.setDataDevolve(LocalDate.of(2022,10,3));

        return ResponseEntity.ok(locacao3);
    }

    //UPDATE
    @PatchMapping("/{id}")
    public ResponseEntity<Locacao> atualizar(@RequestBody Locacao locacao,@PathVariable Integer id){
        locacao.setId(id);

        return ResponseEntity.ok(locacao);
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Integer id){

        return ResponseEntity.noContent().build();
    }

}
