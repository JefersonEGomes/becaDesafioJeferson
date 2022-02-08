package com.becaJavaJeferson.mappers.Locacao;

import com.becaJavaJeferson.dtos.responses.patch.PatchLocacaoResponse;
import com.becaJavaJeferson.model.Locacao;
import org.mapstruct.Mapper;

@Mapper
public interface MapperLocacaoPatchResponse {
    public PatchLocacaoResponse toResponse(Locacao locacao);
}
