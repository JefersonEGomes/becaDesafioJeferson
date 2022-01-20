package com.becaJavaJeferson.model;

public class Locacao {

    private Integer idLocacao;
    private Integer idLocatario;
    private Integer idLocador;
    private Integer idProduto;
    private String dataLocacao;
    private String dataDevolve;

    public Integer getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(Integer idLocacao) {
        this.idLocacao = idLocacao;
    }

    public Integer getIdLocatario() {
        return idLocatario;
    }

    public void setIdLocatario(Integer idLocatario) {
        this.idLocatario = idLocatario;
    }

    public Integer getIdLocador() {
        return idLocador;
    }

    public void setIdLocador(Integer idLocador) {
        this.idLocador = idLocador;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(String dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public String getDataDevolve() {
        return dataDevolve;
    }

    public void setDataDevolve(String dataDevolve) {
        this.dataDevolve = dataDevolve;
    }
}
