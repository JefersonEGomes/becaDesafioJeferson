package com.becaJavaJeferson.model;

// @Data para criar os getters e setters futuramente
public class Produto {
    private Integer idProduto;
    private String nome;
    private String categoria;
    private Double preco;
    private Integer idLocador;

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
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

    public Integer getIdLocador() {
        return idLocador;
    }

    public void setIdLocador(Integer idLocador) {
        this.idLocador = idLocador;
    }

}
