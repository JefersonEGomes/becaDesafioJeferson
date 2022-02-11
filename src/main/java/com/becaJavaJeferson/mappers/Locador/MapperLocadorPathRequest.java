package com.becaJavaJeferson.mappers.Locador;

import com.becaJavaJeferson.dtos.requests.patch.PatchLocadorRequest;
import com.becaJavaJeferson.model.Locador;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface MapperLocadorPathRequest {
    public void atualizar(PatchLocadorRequest patchLocadorRequest, @MappingTarget Locador locador);
}
