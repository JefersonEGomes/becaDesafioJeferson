package com.becaJavaJeferson.mappers.Locador;

import com.becaJavaJeferson.dtos.responses.gets.lists.GetLocadorListResponse;
import com.becaJavaJeferson.model.Locador;
import org.mapstruct.Mapper;

@Mapper
public interface MapperLocadorListGetResponse {
    public GetLocadorListResponse toResponse(Locador locador);

}
