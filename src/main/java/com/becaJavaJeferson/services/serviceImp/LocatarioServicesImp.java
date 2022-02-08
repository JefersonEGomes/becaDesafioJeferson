package com.becaJavaJeferson.services.serviceImp;

import com.becaJavaJeferson.dtos.requests.patch.PatchLocatarioRequest;
import com.becaJavaJeferson.dtos.requests.posts.PostLocatarioRequest;
import com.becaJavaJeferson.dtos.responses.gets.ids.GetLocatarioResponse;
import com.becaJavaJeferson.dtos.responses.gets.lists.GetLocatarioListResponse;
import com.becaJavaJeferson.dtos.responses.patch.PatchLocatarioResponse;
import com.becaJavaJeferson.dtos.responses.posts.PostLocatarioResponse;
import com.becaJavaJeferson.mappers.Locatario.*;
import com.becaJavaJeferson.model.Locatario;
import com.becaJavaJeferson.repositories.LocatarioRepository;
import com.becaJavaJeferson.services.LocatarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocatarioServicesImp  implements LocatarioService{


    private final LocatarioRepository locatarioRepository;
    private final MapperLocatarioRequest mapperLocatarioRequest;
    private final MapperLocatarioResponse mapperLocatarioResponse;
    private final MapperLocatarioPatchRequest mapperLocatarioPatchRequest;
    private final MapperLocatarioPatchResponse mapperLocatarioPatchResponse;
    private final MapperLocatarioGetResponse mapperLocatarioGetResponse;
    private final MapperLocatarioListGetResponse mapperLocatarioListGetResponse;


    //CREATE
    public PostLocatarioResponse criar(PostLocatarioRequest postLocatarioRequest){

        Locatario locatario = mapperLocatarioRequest.toModel(postLocatarioRequest);
        Locatario locatarioSalvo = locatarioRepository.save(locatario);
        PostLocatarioResponse postLocatarioResponse = mapperLocatarioResponse.toResponse(locatario);
        postLocatarioResponse.setMensagem("Olá "+locatarioSalvo.getNome()+" seu registro de locatário foi criado com sucesso");

        return postLocatarioResponse;
    }

    //READ
    @Override
    public List<GetLocatarioListResponse> listar(){
        List<Locatario> listaLocatarios = locatarioRepository.findAll();

        return listaLocatarios.stream().map(mapperLocatarioListGetResponse::toResponse).collect(Collectors.toList());
    }


    public GetLocatarioResponse obter(Integer id){
        Locatario locatario = locatarioRepository.findById(id).get();

        if(locatario == null){
            throw new RuntimeException("O id do locatario não foi encontrado");
        }

        return mapperLocatarioGetResponse.toResponse(locatario);
    }

    //UPDATE
    @Override
    public PatchLocatarioResponse atualizar(PatchLocatarioRequest patchLocatarioRequest, Integer id){
        Locatario locatarioObtido = locatarioRepository.findById(id).get();
        mapperLocatarioPatchRequest.atualizar(patchLocatarioRequest, locatarioObtido);
        locatarioRepository.save(locatarioObtido);

        PatchLocatarioResponse patchLocatarioResponse = mapperLocatarioPatchResponse.toResponse(locatarioObtido);
        patchLocatarioResponse.setMensagem("Locatário "+locatarioObtido.getNome()+" atualizado com sucesso");

        return patchLocatarioResponse;
    }

    //DELETE

    public void deletar(Integer id){
        locatarioRepository.deleteById(id);
    }
}
