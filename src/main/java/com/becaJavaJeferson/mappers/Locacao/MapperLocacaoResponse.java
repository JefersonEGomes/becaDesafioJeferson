package com.becaJavaJeferson.mappers.Locacao;

import com.becaJavaJeferson.dtos.responses.posts.PostLocacaoResponse;
import com.becaJavaJeferson.model.Locacao;
import org.mapstruct.Mapper;

@Mapper
public interface MapperLocacaoResponse {
    public PostLocacaoResponse toResponse(Locacao locacao);
}
