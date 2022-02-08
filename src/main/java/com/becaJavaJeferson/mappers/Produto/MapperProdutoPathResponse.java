package com.becaJavaJeferson.mappers.Produto;

import com.becaJavaJeferson.dtos.responses.patch.PatchProdutoResponse;
import com.becaJavaJeferson.model.Produto;
import org.mapstruct.Mapper;

@Mapper
public interface MapperProdutoPathResponse {
    public PatchProdutoResponse toResponse(Produto produto);
}
