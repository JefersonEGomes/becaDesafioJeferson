package com.becaJavaJeferson.dtos.responses.gets.ids;

import java.time.LocalDate;

public class GetLocacaoResponse {


    private LocalDate dataAluguel;
    private LocalDate dataDevolve;
    private GetLocatarioResponse locatario;

    public GetLocatarioResponse getLocatario() {
        return locatario;
    }

    public void setLocatario(GetLocatarioResponse locatario) {
        this.locatario = locatario;
    }

    public GetProdutoResponse getProduto() {
        return produto;
    }

    public void setProduto(GetProdutoResponse produto) {
        this.produto = produto;
    }

    private GetProdutoResponse produto;


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
