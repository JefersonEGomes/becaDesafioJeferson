package com.becaJavaJeferson.services;

import com.becaJavaJeferson.model.Produto;

import java.util.List;

public interface ProdutoService {

    Produto criar(Produto produto);

    List<Produto> listar();

    Produto obter(Integer id);

    Produto atualizar(Produto produto, Integer id);

    void deletar(Integer id);
}
