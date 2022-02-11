package com.becaJavaJeferson.mappers.Locador;

import com.becaJavaJeferson.dtos.responses.gets.ids.GetLocadorResponse;
import com.becaJavaJeferson.model.Locador;
import org.mapstruct.Mapper;

@Mapper
public interface MapperLocadorGetResponse {
    public GetLocadorResponse toResponse(Locador locador);
}
