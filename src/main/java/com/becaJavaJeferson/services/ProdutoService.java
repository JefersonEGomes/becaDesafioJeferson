package com.becaJavaJeferson.services;

import com.becaJavaJeferson.dtos.requests.PostProdutoRequest;
import com.becaJavaJeferson.dtos.responses.PostProdutoResponse;
import com.becaJavaJeferson.model.Produto;

import java.util.List;

public interface ProdutoService {

    PostProdutoResponse criar(PostProdutoRequest postProdutoRequest);

    List<Produto> listar();

    Produto obter(Integer id);

    Produto atualizar(Produto produto, Integer id);

    void deletar(Integer id);
}
