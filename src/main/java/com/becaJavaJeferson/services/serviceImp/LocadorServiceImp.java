package com.becaJavaJeferson.services.serviceImp;

import com.becaJavaJeferson.dtos.requests.posts.PostLocadorRequest;
import com.becaJavaJeferson.dtos.responses.gets.ids.GetLocadorResponse;
import com.becaJavaJeferson.dtos.responses.gets.lists.GetLocadorListResponse;
import com.becaJavaJeferson.dtos.responses.posts.PostLocadorResponse;
import com.becaJavaJeferson.model.Locador;
import com.becaJavaJeferson.repositories.LocadorRepository;
import com.becaJavaJeferson.services.LocadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocadorServiceImp implements LocadorService {

    @Autowired
    private LocadorRepository locadorRepository;

    // CREATE

    public PostLocadorResponse criar(PostLocadorRequest postLocadorRequest){
        Locador locador = new Locador();
        locador.setNome(postLocadorRequest.getNome());
        locador.setIdade(postLocadorRequest.getIdade());
        locador.setTelefone(postLocadorRequest.getTelefone());
        locador.setCpf(postLocadorRequest.getCpf());

        if( locador.getNome().length() <= 3){
            throw new RuntimeException("O nome do Locador não pode ter menos de 4 caracteres");
        }

        Locador locadorSalvo = locadorRepository.save(locador);

        PostLocadorResponse postLocadorResponse = new PostLocadorResponse();
        postLocadorResponse.setMensagem("Olá "+locadorSalvo.getNome()+" seu registro de locador foi criado com sucesso");

        return postLocadorResponse;
    }

    // READ
    // vai ter request
    @Override
    public List<GetLocadorListResponse> listar(){
        List<Locador> listaLocadores = locadorRepository.findAll();
        List<GetLocadorListResponse> getLocadorListar = new ArrayList<>();

        listaLocadores.stream().forEach(locador -> getLocadorListar.add(new GetLocadorListResponse(locador)));

        return getLocadorListar;
    }

    @Override
    public GetLocadorResponse obter(Integer id){

        Locador locador = locadorRepository.findById(id).get();

        if(locador == null){
            throw new RuntimeException("O id do locador não foi encontrado");
        }

        GetLocadorResponse getLocadorResponse = new GetLocadorResponse();
        getLocadorResponse.setId(locador.getId());
        getLocadorResponse.setNome(locador.getNome());
        getLocadorResponse.setIdade(locador.getIdade());
        getLocadorResponse.setTelefone(locador.getTelefone());
        getLocadorResponse.setCpf(locador.getCpf());

        return getLocadorResponse;
    }

    // UPDATE
//    @Override
//    public Locador atualizar(Locador locador,Integer id){
//        Locador locadorObtido = this.obter(id);
//        locadorObtido.setNome( locador.getNome());
//        locadorObtido.setCpf( locador.getCpf());
//        locadorObtido.setIdade( locador.getIdade());
//        locadorObtido.setTelefone( locador.getTelefone());
//
//        if( locador.getNome().length() <= 3){
//            throw new RuntimeException("O nome do Locador não pode ter menos de 4 caracteres");
//        }
//
//        locadorRepository.save(locadorObtido);
//        return locadorObtido;
//
//    }

    // DELETE
    @Override
    public void deletar(Integer id) {
        locadorRepository.deleteById(id);
    }
}
