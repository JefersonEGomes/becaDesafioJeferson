package com.becaJavaJeferson.dtos.responses.gets.lists;

import com.becaJavaJeferson.model.Locacao;

import java.time.LocalDate;

public class GetLocacaoListResponse {

    private String produto;
    private String locador;
    private String locatario;
    private LocalDate dataAluguel;
    private LocalDate dataDevolve;

    public GetLocacaoListResponse(Locacao locacao){
        this.setProduto(locacao.getProduto().getNome());
        this.setLocador(locacao.getProduto().getLocador().getNome());
        this.setLocatario(locacao.getLocatario().getNome());
        this.setDataAluguel(locacao.getDataAluguel());
        this.setDataDevolve(locacao.getDataDevolve());
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getLocador() {
        return locador;
    }

    public void setLocador(String locador) {
        this.locador = locador;
    }

    public String getLocatario() {
        return locatario;
    }

    public void setLocatario(String locatario) {
        this.locatario = locatario;
    }

    public LocalDate getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(LocalDate dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public LocalDate getDataDevolve() {
        return dataDevolve;
    }

    public void setDataDevolve(LocalDate dataDevolve) {
        this.dataDevolve = dataDevolve;
    }
}
