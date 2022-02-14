package com.becaJavaJeferson.controllers;

import com.becaJavaJeferson.dtos.requests.patch.PatchProdutoRequest;
import com.becaJavaJeferson.dtos.requests.posts.PostProdutoRequest;
import com.becaJavaJeferson.dtos.responses.gets.ids.GetProdutoResponse;
import com.becaJavaJeferson.dtos.responses.gets.lists.GetProdutoListResponse;
import com.becaJavaJeferson.dtos.responses.patch.PatchProdutoResponse;
import com.becaJavaJeferson.dtos.responses.posts.PostProdutoResponse;
import com.becaJavaJeferson.services.serviceImp.ProdutoServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoController {


    private final ProdutoServiceImp produtoService;

    //CREATE
    @PostMapping
    public ResponseEntity<PostProdutoResponse> criar(@RequestBody @Valid PostProdutoRequest postProdutoRequest){

        PostProdutoResponse postProdutoResponse = produtoService.criar(postProdutoRequest);

        return ResponseEntity.created(null).body(postProdutoResponse);

    }

    // READ
    @GetMapping
    public ResponseEntity<List<GetProdutoListResponse>> listar(){
        List<GetProdutoListResponse> listaProdutos = produtoService.listar();

        return ResponseEntity.ok(listaProdutos);

    }

    @GetMapping("/{id}")
    public ResponseEntity<GetProdutoResponse> obter(@PathVariable Integer id){
        GetProdutoResponse getProdutoResponse = produtoService.obter(id);

        return ResponseEntity.ok(getProdutoResponse);
    }

    // UPDATE
    @PatchMapping("/{id}")
    public ResponseEntity<PatchProdutoResponse> atualizar(@RequestBody @Valid PatchProdutoRequest patchProdutoRequest, @PathVariable Integer id){
        PatchProdutoResponse produtoAtualizado = produtoService.atualizar(patchProdutoRequest, id);

        return ResponseEntity.ok(produtoAtualizado);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Integer id){
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();

    }
}
