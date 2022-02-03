package com.becaJavaJeferson.dtos.responses.gets.lists;

import com.becaJavaJeferson.model.Locador;

public class GetLocadorListResponse {

    private String nome;
    private Integer idade;

    public GetLocadorListResponse(Locador locador){
        this.setNome(locador.getNome());
        this.setIdade(locador.getIdade());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
