package com.becaJavaJeferson.services;

import com.becaJavaJeferson.dtos.requests.patch.PatchLocatarioRequest;
import com.becaJavaJeferson.dtos.requests.posts.PostLocatarioRequest;
import com.becaJavaJeferson.dtos.responses.gets.ids.GetLocatarioResponse;
import com.becaJavaJeferson.dtos.responses.gets.lists.GetLocatarioListResponse;
import com.becaJavaJeferson.dtos.responses.patch.PatchLocatarioResponse;
import com.becaJavaJeferson.dtos.responses.posts.PostLocatarioResponse;

import java.util.List;

public interface LocatarioService {

    PostLocatarioResponse criar (PostLocatarioRequest postLocatarioRequest);

    List<GetLocatarioListResponse> listar();

    GetLocatarioResponse obter (Integer id);

    PatchLocatarioResponse atualizar(PatchLocatarioRequest patchLocatarioRequest, Integer id);

    void deletar(Integer id);
}
