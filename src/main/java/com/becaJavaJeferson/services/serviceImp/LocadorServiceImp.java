package com.becaJavaJeferson.services.serviceImp;

import com.becaJavaJeferson.dtos.requests.patch.PatchLocadorRequest;
import com.becaJavaJeferson.dtos.requests.posts.PostLocadorRequest;
import com.becaJavaJeferson.dtos.responses.gets.ids.GetLocadorResponse;
import com.becaJavaJeferson.dtos.responses.gets.lists.GetLocadorListResponse;
import com.becaJavaJeferson.dtos.responses.patch.PatchLocadorResponse;
import com.becaJavaJeferson.dtos.responses.posts.PostLocadorResponse;
import com.becaJavaJeferson.mappers.Locador.*;
import com.becaJavaJeferson.model.Locador;
import com.becaJavaJeferson.repositories.LocadorRepository;
import com.becaJavaJeferson.services.LocadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocadorServiceImp implements LocadorService {

    private final LocadorRepository locadorRepository;
    private final MapperLocadorRequest mapperLocadorRequest;
    private final MapperLocadorResponse mapperLocadorResponse;
    private final MapperLocadorPathRequest mapperLocadorPathRequest;
    private final MapperLocadorPatchResponse mapperLocadorPatchResponse;
    private final MapperLocadorListGetResponse mapperLocadorListGetResponse;
    private  final MapperLocadorGetResponse mapperLocadorGetResponse;

    // CREATE
    public PostLocadorResponse criar(PostLocadorRequest postLocadorRequest){

        Locador locador = mapperLocadorRequest.toModel(postLocadorRequest);
        locadorRepository.save(locador);
        PostLocadorResponse postLocadorResponse = mapperLocadorResponse.toResponse(locador);
        postLocadorResponse.setMensagem("Olá "+locador.getNome()+" seu registro de locador foi criado com sucesso");
        return postLocadorResponse;
    }

    // READ
    @Override
    public List<GetLocadorListResponse> listar(){
        List<Locador> listaLocadores = locadorRepository.findAll();

        return listaLocadores.stream().map(mapperLocadorListGetResponse::toResponse).collect(Collectors.toList());

    }

    @Override
    public GetLocadorResponse obter(Integer id){

        Locador locador = locadorRepository.findById(id).get();

        if(locador == null){
            throw new RuntimeException("O id do locador não foi encontrado");
        }


        return mapperLocadorGetResponse.toResponse(locador);
    }

    // UPDATE
    @Override
    public PatchLocadorResponse atualizar(PatchLocadorRequest patchLocadorRequest, Integer id){
        Locador locadorObtido = locadorRepository.findById(id).get();
        mapperLocadorPathRequest.atualizar(patchLocadorRequest, locadorObtido);
        locadorRepository.save(locadorObtido);

        PatchLocadorResponse patchLocadorResponse = mapperLocadorPatchResponse.toResponse(locadorObtido);
        patchLocadorResponse.setMensagem("Locador "+locadorObtido.getNome()+" atualizado com sucesso");

        return patchLocadorResponse;

    }

    private void locatarioObtidoMethod(PatchLocadorRequest patchLocadorRequest, Locador locadorObtido) {
        locadorObtido.setNome( patchLocadorRequest.getNome());
        locadorObtido.setCpf( patchLocadorRequest.getCpf());
        locadorObtido.setIdade( patchLocadorRequest.getIdade());
        locadorObtido.setTelefone( patchLocadorRequest.getTelefone());
    }

    // DELETE
    @Override
    public void deletar(Integer id) {
        locadorRepository.deleteById(id);
    }
}
