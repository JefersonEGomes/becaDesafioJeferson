package com.becaJavaJeferson.mappers.Locador;

import com.becaJavaJeferson.dtos.responses.patch.PatchLocadorResponse;
import com.becaJavaJeferson.model.Locador;
import org.mapstruct.Mapper;

@Mapper
public interface MapperLocadorPatchResponse {
    public PatchLocadorResponse toResponse(Locador locador);
}
