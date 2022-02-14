package com.becaJavaJeferson.mappers.Locador;

import com.becaJavaJeferson.dtos.requests.posts.PostLocadorRequest;
import com.becaJavaJeferson.model.Locador;
import org.mapstruct.Mapper;

@Mapper
public interface MapperLocadorRequest {
    public Locador toModel(PostLocadorRequest postLocadorRequest);
}
