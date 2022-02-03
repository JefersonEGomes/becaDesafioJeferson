package com.becaJavaJeferson.services;

import com.becaJavaJeferson.dtos.requests.patch.PatchProdutoRequest;
import com.becaJavaJeferson.dtos.requests.posts.PostProdutoRequest;
import com.becaJavaJeferson.dtos.responses.gets.ids.GetProdutoResponse;
import com.becaJavaJeferson.dtos.responses.gets.lists.GetProdutoListResponse;
import com.becaJavaJeferson.dtos.responses.patch.PatchProdutoResponse;
import com.becaJavaJeferson.dtos.responses.posts.PostProdutoResponse;
import com.becaJavaJeferson.model.Produto;

import java.util.List;

public interface ProdutoService {

    PostProdutoResponse criar(PostProdutoRequest postProdutoRequest);

    List<GetProdutoListResponse> listar();

    GetProdutoResponse obter(Integer id);

    PatchProdutoResponse atualizar(PatchProdutoRequest patchProdutoRequest, Integer id);

    void deletar(Integer id);
}
