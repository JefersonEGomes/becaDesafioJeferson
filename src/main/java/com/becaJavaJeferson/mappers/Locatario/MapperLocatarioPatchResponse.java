package com.becaJavaJeferson.mappers.Locatario;

import com.becaJavaJeferson.dtos.responses.patch.PatchLocatarioResponse;
import com.becaJavaJeferson.model.Locatario;
import org.mapstruct.Mapper;

@Mapper
public interface MapperLocatarioPatchResponse {
    public PatchLocatarioResponse toResponse(Locatario locatario);
}
