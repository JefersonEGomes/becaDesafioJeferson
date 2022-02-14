package com.becaJavaJeferson.mappers.Locatario;

import com.becaJavaJeferson.dtos.responses.posts.PostLocatarioResponse;
import com.becaJavaJeferson.model.Locatario;
import org.mapstruct.Mapper;

@Mapper
public interface MapperLocatarioResponse {
    public PostLocatarioResponse toResponse(Locatario locatario);
}
