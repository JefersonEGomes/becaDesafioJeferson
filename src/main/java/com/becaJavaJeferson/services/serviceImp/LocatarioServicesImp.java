package com.becaJavaJeferson.services.serviceImp;

import com.becaJavaJeferson.dtos.requests.patch.PatchLocatarioRequest;
import com.becaJavaJeferson.dtos.requests.posts.PostLocatarioRequest;
import com.becaJavaJeferson.dtos.responses.gets.ids.GetLocatarioResponse;
import com.becaJavaJeferson.dtos.responses.gets.lists.GetLocatarioListResponse;
import com.becaJavaJeferson.dtos.responses.patch.PatchLocatarioResponse;
import com.becaJavaJeferson.dtos.responses.posts.PostLocatarioResponse;
import com.becaJavaJeferson.model.Locatario;
import com.becaJavaJeferson.repositories.LocatarioRepository;
import com.becaJavaJeferson.services.LocatarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocatarioServicesImp  implements LocatarioService{

    @Autowired
    private LocatarioRepository locatarioRepository;

    //CREATE

    public PostLocatarioResponse criar(PostLocatarioRequest postLocatarioRequest){
        Locatario locatario = new Locatario();
        locatario.setNome(postLocatarioRequest.getNome());
        locatario.setIdade(postLocatarioRequest.getIdade());
        locatario.setCpf(postLocatarioRequest.getCpf());
        locatario.setTelefone(postLocatarioRequest.getTelefone());

        if( postLocatarioRequest.getNome().length() <= 3){
            throw new RuntimeException("O nome do Locatário não pode ter menos de 4 caracteres");

        }

        Locatario locatarioSalvo = locatarioRepository.save(locatario);

        PostLocatarioResponse postLocatarioResponse = new PostLocatarioResponse();
        postLocatarioResponse.setMensagem("Olá "+locatarioSalvo.getNome()+" seu registro de locatário foi criado com sucesso");

        return postLocatarioResponse;
    }

    //READ
    @Override
    public List<GetLocatarioListResponse> listar(){
        List<Locatario> listaLocatarios = locatarioRepository.findAll();
        List<GetLocatarioListResponse> getLocatarioListar = new ArrayList<>();

        listaLocatarios.stream().forEach(locatario -> getLocatarioListar.add(new GetLocatarioListResponse(locatario)));

        return getLocatarioListar;
    }


    public GetLocatarioResponse obter(Integer id){
        Locatario locatario = locatarioRepository.findById(id).get();

        if(locatario == null){
            throw new RuntimeException("O id do locatario não foi encontrado");
        }

        GetLocatarioResponse getLocatarioResponse = new GetLocatarioResponse();
        getLocatarioResponse.setId(locatario.getId());
        getLocatarioResponse.setNome(locatario.getNome());
        getLocatarioResponse.setIdade(locatario.getIdade());
        getLocatarioResponse.setTelefone(locatario.getTelefone());
        getLocatarioResponse.setCpf(locatario.getCpf());

        return getLocatarioResponse;
    }

    //UPDATE
    @Override
    public PatchLocatarioResponse atualizar(PatchLocatarioRequest patchLocatarioRequest, Integer id){

        Locatario locatarioObtido = locatarioRepository.findById(id).get();
        locatarioObtido.setNome( patchLocatarioRequest.getNome());
        locatarioObtido.setCpf( patchLocatarioRequest.getCpf());
        locatarioObtido.setIdade( patchLocatarioRequest.getIdade());
        locatarioObtido.setTelefone( patchLocatarioRequest.getTelefone());

        locatarioRepository.save(locatarioObtido);

        PatchLocatarioResponse patchLocatarioResponse = new PatchLocatarioResponse();
        patchLocatarioResponse.setMensagem("Locatário "+locatarioObtido.getNome()+" atualizado com sucesso");

        return patchLocatarioResponse;
    }

    //DELETE

    public void deletar(Integer id){
        locatarioRepository.deleteById(id);
    }
}
