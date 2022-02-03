package com.becaJavaJeferson.services;

import com.becaJavaJeferson.dtos.requests.patch.PatchLocadorRequest;
import com.becaJavaJeferson.dtos.requests.posts.PostLocadorRequest;
import com.becaJavaJeferson.dtos.responses.gets.ids.GetLocadorResponse;
import com.becaJavaJeferson.dtos.responses.gets.lists.GetLocadorListResponse;
import com.becaJavaJeferson.dtos.responses.patch.PatchLocadorResponse;
import com.becaJavaJeferson.dtos.responses.posts.PostLocadorResponse;

import java.util.List;

public interface LocadorService {

    PostLocadorResponse criar (PostLocadorRequest postLocadorRequest);

    List<GetLocadorListResponse> listar();

    GetLocadorResponse obter (Integer id);

    PatchLocadorResponse atualizar(PatchLocadorRequest patchLocadorRequest, Integer id);

    void deletar(Integer id);
}
