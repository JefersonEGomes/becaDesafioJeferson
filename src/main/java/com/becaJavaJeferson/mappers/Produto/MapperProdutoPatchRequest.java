package com.becaJavaJeferson.mappers.Produto;

import com.becaJavaJeferson.dtos.requests.patch.PatchProdutoRequest;
import com.becaJavaJeferson.model.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface MapperProdutoPatchRequest {
    public void atualizar(PatchProdutoRequest patchProdutoRequest, @MappingTarget Produto produto);
}
