package com.becaJavaJeferson.mappers.Locacao;

import com.becaJavaJeferson.dtos.requests.patch.PatchLocacaoRequest;
import com.becaJavaJeferson.model.Locacao;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface MapperLocacaoPatchRequest {
    public void atualizar(PatchLocacaoRequest patchLocacaoRequest, @MappingTarget Locacao locacao);
}
