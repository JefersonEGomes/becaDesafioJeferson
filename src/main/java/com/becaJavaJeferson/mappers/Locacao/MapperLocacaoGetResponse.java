package com.becaJavaJeferson.mappers.Locacao;

import com.becaJavaJeferson.dtos.responses.gets.ids.GetLocacaoResponse;
import com.becaJavaJeferson.model.Locacao;
import org.mapstruct.Mapper;

@Mapper
public interface MapperLocacaoGetResponse {
    public GetLocacaoResponse toResponse(Locacao locacao);
}
