package com.becaJavaJeferson.mappers.Locacao;

import com.becaJavaJeferson.dtos.requests.posts.PostLocacaoRequest;
import com.becaJavaJeferson.model.Locacao;
import org.mapstruct.Mapper;

@Mapper
public interface MapperLocacaoRequest {
    public Locacao toModel(PostLocacaoRequest postLocacaoRequest);
}
