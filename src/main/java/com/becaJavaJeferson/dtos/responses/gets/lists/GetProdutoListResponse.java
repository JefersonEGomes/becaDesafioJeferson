package com.becaJavaJeferson.dtos.responses.gets.lists;

import com.becaJavaJeferson.model.Produto;

public class GetProdutoListResponse {

    private String nome;
    private String categoria;
    private String locador;

    public GetProdutoListResponse(Produto produto){
        this.setNome(produto.getNome());
        this.setCategoria(produto.getCategoria());
        this.setLocador(produto.getLocador().getNome());
    }

    public String getLocador() {
        return locador;
    }

    public void setLocador(String locador) {
        this.locador = locador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
