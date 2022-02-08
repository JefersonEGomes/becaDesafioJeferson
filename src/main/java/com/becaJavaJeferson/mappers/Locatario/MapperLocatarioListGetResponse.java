package com.becaJavaJeferson.mappers.Locatario;

import com.becaJavaJeferson.dtos.responses.gets.lists.GetLocatarioListResponse;
import com.becaJavaJeferson.model.Locatario;
import org.mapstruct.Mapper;

@Mapper
public interface MapperLocatarioListGetResponse {
    public GetLocatarioListResponse toResponse(Locatario locatario);
}
