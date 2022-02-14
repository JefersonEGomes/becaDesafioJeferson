package com.becaJavaJeferson.mappers.Locatario;

import com.becaJavaJeferson.dtos.responses.gets.ids.GetLocatarioResponse;
import com.becaJavaJeferson.model.Locatario;
import org.mapstruct.Mapper;

@Mapper
public interface MapperLocatarioGetResponse {
    public GetLocatarioResponse toResponse(Locatario locatario);
}
