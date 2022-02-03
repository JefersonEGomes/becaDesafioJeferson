package com.becaJavaJeferson.dtos.requests.posts;

import java.time.LocalDate;

public class PostLocacaoRequest {

    private LocalDate dataAluguel;
    private LocalDate dataDevolve;
    private Integer idLocatario;
    private Integer idProduto;


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

    public Integer getIdLocatario() {
        return idLocatario;
    }

    public void setIdLocatario(Integer idLocatario) {
        this.idLocatario = idLocatario;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }
}
