package com.becaJavaJeferson.dtos.responses.gets.ids;

public class GetProdutoResponse {
    private Integer id;
    private String nome;
    private String categoria;
    private Double preco;
    private GetLocadorResponse locador;


    public GetLocadorResponse getLocador() {
        return locador;
    }

    public void setLocador(GetLocadorResponse locador) {
        this.locador = locador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }


}
