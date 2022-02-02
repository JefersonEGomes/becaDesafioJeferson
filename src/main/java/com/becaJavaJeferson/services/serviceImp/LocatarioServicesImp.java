package com.becaJavaJeferson.services.serviceImp;

import com.becaJavaJeferson.dtos.requests.posts.PostLocatarioRequest;
import com.becaJavaJeferson.dtos.responses.posts.PostLocatarioResponse;
import com.becaJavaJeferson.model.Locatario;
import com.becaJavaJeferson.repositories.LocatarioRepository;
import com.becaJavaJeferson.services.LocatarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Locatario> listar(){
        List<Locatario> listaLocatarios = locatarioRepository.findAll();

        return listaLocatarios;
    }


    public Locatario obter(Integer id){
        Locatario locatario = locatarioRepository.findById(id).get();

        if(locatario == null){
            throw new RuntimeException("O id do locatario não foi encontrado");
        }

        return locatario;
    }

    //UPDATE

    public Locatario atualizar(Locatario locatario, Integer id){
        Locatario locatarioObtido = this.obter(id);
        locatarioObtido.setNome( locatario.getNome());
        locatarioObtido.setCpf( locatario.getCpf());
        locatarioObtido.setIdade( locatario.getIdade());
        locatarioObtido.setTelefone( locatario.getTelefone());


        locatarioRepository.save(locatarioObtido);
        return locatarioObtido;
    }

    //DELETE

    public void deletar(Integer id){
        locatarioRepository.deleteById(id);
    }
}
