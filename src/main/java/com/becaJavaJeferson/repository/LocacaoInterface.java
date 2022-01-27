package com.becaJavaJeferson.repository;

import com.becaJavaJeferson.model.Locacao;

import java.util.List;

public interface LocacaoInterface {

    Locacao criar(Locacao locacao);

    List<Locacao> listar();

    Locacao obter(Integer id);

    Locacao atualizar(Locacao locacao,Integer id);

    void deletar(Integer id);
}