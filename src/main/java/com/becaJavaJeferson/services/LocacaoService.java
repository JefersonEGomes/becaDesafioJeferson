package com.becaJavaJeferson.services;

import com.becaJavaJeferson.dtos.requests.posts.PostLocacaoRequest;
import com.becaJavaJeferson.dtos.responses.posts.PostLocacaoResponse;
import com.becaJavaJeferson.model.Locacao;

import java.util.List;

public interface LocacaoService {
    PostLocacaoResponse criar(PostLocacaoRequest postLocacaoRequest);

    List<Locacao> listar();

    Locacao obter(Integer id);

    Locacao atualizar(Locacao locacao,Integer id);

    void deletar(Integer id);
}
