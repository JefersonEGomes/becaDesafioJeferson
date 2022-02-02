package com.becaJavaJeferson.services;

import com.becaJavaJeferson.dtos.requests.PostLocatarioRequest;
import com.becaJavaJeferson.dtos.responses.PostLocatarioResponse;
import com.becaJavaJeferson.model.Locatario;

import java.util.List;

public interface LocatarioService {

    PostLocatarioResponse criar (PostLocatarioRequest postLocatarioRequest);

    List<Locatario> listar();

    Locatario obter (Integer id);

    Locatario atualizar(Locatario locatario, Integer id);

    void deletar(Integer id);
}
