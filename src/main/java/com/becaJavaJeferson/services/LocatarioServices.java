package com.becaJavaJeferson.services;

import com.becaJavaJeferson.model.Locatario;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@Service
public class LocatarioServices {

    //CREATE
    public Locatario criar(Locatario locatario){
        Random randomId = new Random();
        locatario.setId(randomId.nextInt(1000));

        if( locatario.getNome().length() <= 3){
            throw new RuntimeException("O nome do Locatário não pode ter menos de 4 caracteres");

        }

        return locatario;
    }

    //READ
    public List<Locatario> listar(){
        Locatario locatario1 = new Locatario();
        Locatario locatario2 = new Locatario();

        locatario1.setId(1);
        locatario1.setNome("Jeferson");
        locatario1.setCpf(11111111111L);
        locatario1.setIdade(22);
        locatario1.setTelefone(819999999L);
        locatario1.setId(1);

        locatario2.setId(2);
        locatario2.setNome("Jackson");
        locatario2.setCpf(22222222222L);
        locatario2.setIdade(33);
        locatario2.setTelefone(81922222222L);
        locatario2.setId(2);

        return List.of(
                locatario1,
                locatario2
        );
    }

    public Locatario obter(Integer id){
        Locatario locatario = new Locatario();

        locatario.setId(id);
        locatario.setNome("James");
        locatario.setCpf(33333333333L);
        locatario.setIdade(44);
        locatario.setTelefone(81933333333L);
        locatario.setId(5);

        return locatario;
    }

    //UPDATE
    public Locatario atualizar(Locatario locatario, Integer id){
        locatario.setId(id);

        return locatario;
    }

    //DELETE
    public void deletar(Integer id){

    }
}
