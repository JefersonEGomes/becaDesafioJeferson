package com.becaJavaJeferson.services;

import com.becaJavaJeferson.dtos.requests.posts.PostProdutoRequest;
import com.becaJavaJeferson.dtos.responses.gets.ids.GetProdutoResponse;
import com.becaJavaJeferson.dtos.responses.posts.PostProdutoResponse;
import com.becaJavaJeferson.model.Produto;

import java.util.List;

public interface ProdutoService {

    PostProdutoResponse criar(PostProdutoRequest postProdutoRequest);

    List<Produto> listar();

    GetProdutoResponse obter(Integer id);

    //Produto atualizar(Produto produto, Integer id);

    void deletar(Integer id);
}
