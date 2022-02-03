package com.becaJavaJeferson.dtos.responses.gets.ids;

import java.time.LocalDate;

public class GetLocacaoResponse {

    private Integer id;
    private LocalDate dataAluguel;
    private LocalDate dataDevolve;
    private GetLocatarioResponse getLocatarioResponse;
    private GetProdutoResponse getProdutoResponse;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public GetLocatarioResponse getGetLocatarioResponse() {
        return getLocatarioResponse;
    }

    public void setGetLocatarioResponse(GetLocatarioResponse getLocatarioResponse) {
        this.getLocatarioResponse = getLocatarioResponse;
    }

    public GetProdutoResponse getGetProdutoResponse() {
        return getProdutoResponse;
    }

    public void setGetProdutoResponse(GetProdutoResponse getProdutoResponse) {
        this.getProdutoResponse = getProdutoResponse;
    }
}
