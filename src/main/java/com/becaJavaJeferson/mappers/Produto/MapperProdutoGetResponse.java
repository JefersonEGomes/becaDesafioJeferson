package com.becaJavaJeferson.mappers.Produto;

import com.becaJavaJeferson.dtos.responses.gets.ids.GetProdutoResponse;
import com.becaJavaJeferson.model.Produto;
import org.mapstruct.Mapper;

@Mapper
public interface MapperProdutoGetResponse {
    public GetProdutoResponse toResponse(Produto produto);
}
