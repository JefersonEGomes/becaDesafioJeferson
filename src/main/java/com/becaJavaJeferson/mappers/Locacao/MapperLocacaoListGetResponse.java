package com.becaJavaJeferson.mappers.Locacao;

import com.becaJavaJeferson.dtos.responses.gets.lists.GetLocacaoListResponse;
import com.becaJavaJeferson.model.Locacao;
import org.mapstruct.Mapper;

@Mapper
public interface MapperLocacaoListGetResponse {
    public GetLocacaoListResponse toResponse(Locacao locacao);
}
