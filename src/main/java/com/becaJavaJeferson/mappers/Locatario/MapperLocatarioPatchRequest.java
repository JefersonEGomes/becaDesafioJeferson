package com.becaJavaJeferson.mappers.Locatario;

import com.becaJavaJeferson.dtos.requests.patch.PatchLocatarioRequest;
import com.becaJavaJeferson.dtos.responses.patch.PatchLocatarioResponse;
import com.becaJavaJeferson.model.Locatario;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface MapperLocatarioPatchRequest {
    public void atualizar (PatchLocatarioRequest patchLocatarioRequest, @MappingTarget Locatario lcoatario);
}
