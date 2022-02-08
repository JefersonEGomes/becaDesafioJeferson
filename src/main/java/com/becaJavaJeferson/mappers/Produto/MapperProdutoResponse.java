package com.becaJavaJeferson.mappers.Produto;

import com.becaJavaJeferson.dtos.responses.posts.PostProdutoResponse;
import com.becaJavaJeferson.model.Produto;
import org.mapstruct.Mapper;

@Mapper
public interface MapperProdutoResponse {
    public PostProdutoResponse toResponse(Produto produto);
}
