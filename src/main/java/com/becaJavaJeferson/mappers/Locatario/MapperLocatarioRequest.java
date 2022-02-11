package com.becaJavaJeferson.mappers.Locatario;

import com.becaJavaJeferson.dtos.requests.posts.PostLocatarioRequest;
import com.becaJavaJeferson.model.Locatario;
import org.mapstruct.Mapper;

@Mapper
public interface MapperLocatarioRequest {
    public Locatario toModel(PostLocatarioRequest postLocatarioRequest);
}
