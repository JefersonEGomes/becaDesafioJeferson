package com.becaJavaJeferson.mappers.Produto;

import com.becaJavaJeferson.dtos.responses.gets.lists.GetProdutoListResponse;
import com.becaJavaJeferson.model.Produto;
import org.mapstruct.Mapper;

@Mapper
public interface MapperProdutoListGetResponse {
    public GetProdutoListResponse toResponse(Produto produto);
}
