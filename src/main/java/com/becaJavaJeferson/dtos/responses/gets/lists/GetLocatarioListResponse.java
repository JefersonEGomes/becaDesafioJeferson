package com.becaJavaJeferson.dtos.responses.gets.lists;

import com.becaJavaJeferson.model.Locatario;

public class GetLocatarioListResponse {

    private String nome;
    private Integer idade;

    public GetLocatarioListResponse(Locatario locatario) {
        this.setNome(locatario.getNome());
        this.setIdade(locatario.getIdade());
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
