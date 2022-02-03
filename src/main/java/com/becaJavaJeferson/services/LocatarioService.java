package com.becaJavaJeferson.services;

import com.becaJavaJeferson.dtos.requests.posts.PostLocatarioRequest;
import com.becaJavaJeferson.dtos.responses.gets.ids.GetLocatarioResponse;
import com.becaJavaJeferson.dtos.responses.gets.lists.GetLocatarioListResponse;
import com.becaJavaJeferson.dtos.responses.posts.PostLocatarioResponse;
import com.becaJavaJeferson.model.Locatario;

import java.util.List;

public interface LocatarioService {

    PostLocatarioResponse criar (PostLocatarioRequest postLocatarioRequest);

    List<GetLocatarioListResponse> listar();

    GetLocatarioResponse obter (Integer id);

    //Locatario atualizar(Locatario locatario, Integer id);

    void deletar(Integer id);
}
