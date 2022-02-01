package com.becaJavaJeferson.services.serviceImp;

import com.becaJavaJeferson.model.Locatario;
import com.becaJavaJeferson.repositories.LocatarioRepository;
import com.becaJavaJeferson.services.LocatarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocatarioServicesImp implements LocatarioService {

    @Autowired
    private LocatarioRepository locatarioRepository;

    //CREATE
    @Override
    public Locatario criar(Locatario locatario){

        if( locatario.getNome().length() <= 3){
            throw new RuntimeException("O nome do Locatário não pode ter menos de 4 caracteres");

        }

        Locatario locatarioSalvo = locatarioRepository.save(locatario);
        return locatarioSalvo;
    }

    //READ
    @Override
    public List<Locatario> listar(){
        List<Locatario> listaLocatarios = locatarioRepository.findAll();

        return listaLocatarios;
    }

    @Override
    public Locatario obter(Integer id){
        Locatario locatario = locatarioRepository.findById(id).get();

        if(locatario == null){
            throw new RuntimeException("O id do locatario não foi encontrado");
        }

        return locatario;
    }

    //UPDATE
    @Override
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
    @Override
    public void deletar(Integer id){
        locatarioRepository.deleteById(id);
    }
}
