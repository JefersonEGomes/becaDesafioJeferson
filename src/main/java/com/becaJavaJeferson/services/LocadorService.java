package com.becaJavaJeferson.services;

import com.becaJavaJeferson.dtos.requests.posts.PostLocadorRequest;
import com.becaJavaJeferson.dtos.responses.gets.ids.GetLocadorResponse;
import com.becaJavaJeferson.dtos.responses.posts.PostLocadorResponse;
import com.becaJavaJeferson.model.Locador;

import java.util.List;

public interface LocadorService {

    PostLocadorResponse criar (PostLocadorRequest postLocadorRequest);

    List<Locador> listar();

    GetLocadorResponse obter (Integer id);

    //Locador atualizar(Locador locador, Integer id);

    void deletar(Integer id);
}
