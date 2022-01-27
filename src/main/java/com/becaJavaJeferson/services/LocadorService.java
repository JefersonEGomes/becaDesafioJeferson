package com.becaJavaJeferson.services;

import com.becaJavaJeferson.model.Locador;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class LocadorService {

    // CREATE
    public Locador criar(Locador locador){

        Random randomId = new Random();
        locador.setId(randomId.nextInt(1000));

        if( locador.getNome().length() <= 3){
            throw new RuntimeException("O nome do Locador não pode ter menos de 4 caracteres");
        }

        return locador;
    }

    // READ
    public List<Locador> listar(){
        Locador locador1 = new Locador();
        Locador locador2 = new Locador();

        locador1.setId(1);
        locador1.setNome("Jeferson");
        locador1.setCpf(11111111111L);
        locador1.setIdade(22);
        locador1.setTelefone(819999999L);
        locador1.setId(1);

        locador2.setId(2);
        locador2.setNome("Jeferson");
        locador2.setCpf(22222222222L);
        locador2.setIdade(33);
        locador2.setTelefone(81922222222L);
        locador2.setId(2);

        return List.of(
                locador1,
                locador2
        );
    }


    public Locador obter(Integer id){
        Locador locador3 = new Locador();
        locador3.setId(id);
        locador3.setId(3);
        locador3.setNome("Magnus");
        locador3.setIdade(19);
        locador3.setTelefone(81955555555L);
        locador3.setCpf(12345678900L);

        return locador3;
    }

    // UPDATE
    public Locador atualizar(Locador locador,Integer id){
        locador.setId(id);

        if( locador.getNome().length() <= 3){
            throw new RuntimeException("O nome do Locador não pode ter menos de 4 caracteres");
        }

        return locador;

    }

    // DELETE
    public void deletar(Integer id){

    }
}
