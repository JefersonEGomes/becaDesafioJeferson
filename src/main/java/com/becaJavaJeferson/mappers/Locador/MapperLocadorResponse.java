package com.becaJavaJeferson.mappers.Locador;

import com.becaJavaJeferson.dtos.responses.posts.PostLocadorResponse;
import com.becaJavaJeferson.model.Locador;
import org.mapstruct.Mapper;

@Mapper
public interface MapperLocadorResponse {
    public PostLocadorResponse toResponse(Locador locdaor);
}
