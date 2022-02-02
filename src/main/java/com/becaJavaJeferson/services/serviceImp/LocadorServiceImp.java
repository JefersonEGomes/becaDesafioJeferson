package com.becaJavaJeferson.services.serviceImp;

import com.becaJavaJeferson.dtos.requests.posts.PostLocadorRequest;
import com.becaJavaJeferson.dtos.responses.posts.PostLocadorResponse;
import com.becaJavaJeferson.model.Locador;
import com.becaJavaJeferson.repositories.LocadorRepository;
import com.becaJavaJeferson.services.LocadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Override
    public List<Locador> listar(){
        List<Locador> listaLocadores = locadorRepository.findAll();

        return listaLocadores;
    }

    @Override
    public Locador obter(Integer id){
        Locador locador = locadorRepository.findById(id).get();

        if(locador == null){
            throw new RuntimeException("O id do locador não foi encontrado");
        }

        return locador;
    }

    // UPDATE
    @Override
    public Locador atualizar(Locador locador,Integer id){
        Locador locadorObtido = this.obter(id);
        locadorObtido.setNome( locador.getNome());
        locadorObtido.setCpf( locador.getCpf());
        locadorObtido.setIdade( locador.getIdade());
        locadorObtido.setTelefone( locador.getTelefone());

        if( locador.getNome().length() <= 3){
            throw new RuntimeException("O nome do Locador não pode ter menos de 4 caracteres");
        }

        locadorRepository.save(locadorObtido);
        return locadorObtido;

    }

    // DELETE
    @Override
    public void deletar(Integer id) {
        locadorRepository.deleteById(id);
    }
}
