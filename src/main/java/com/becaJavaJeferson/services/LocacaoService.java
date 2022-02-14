package com.becaJavaJeferson.services;

import com.becaJavaJeferson.dtos.requests.patch.PatchLocacaoRequest;
import com.becaJavaJeferson.dtos.requests.posts.PostLocacaoRequest;
import com.becaJavaJeferson.dtos.responses.gets.ids.GetLocacaoResponse;
import com.becaJavaJeferson.dtos.responses.gets.lists.GetLocacaoListResponse;
import com.becaJavaJeferson.dtos.responses.patch.PatchLocacaoResponse;
import com.becaJavaJeferson.dtos.responses.posts.PostLocacaoResponse;

import java.util.List;

public interface LocacaoService {
    PostLocacaoResponse criar(PostLocacaoRequest postLocacaoRequest);

    List<GetLocacaoListResponse> listar();

    GetLocacaoResponse obter(Integer id);

    PatchLocacaoResponse atualizar(PatchLocacaoRequest patchLocacaoRequest, Integer id);

    void deletar(Integer id);
}
