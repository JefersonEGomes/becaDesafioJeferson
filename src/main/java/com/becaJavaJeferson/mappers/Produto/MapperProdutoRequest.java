package com.becaJavaJeferson.mappers.Produto;

import com.becaJavaJeferson.dtos.requests.posts.PostProdutoRequest;
import com.becaJavaJeferson.model.Produto;
import org.mapstruct.Mapper;

@Mapper
public interface MapperProdutoRequest {
    public Produto toModel(PostProdutoRequest postProdutoRequest);
}
