package com.becaJavaJeferson.dtos.requests;

public class PostProdutoRequest {

    private String nome;
    private String categoria;
    private Double preco;
    private Integer idLocador;


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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getIdLocador() {
        return idLocador;
    }

    public void setIdLocador(Integer idLocador) {
        this.idLocador = idLocador;
    }
}
