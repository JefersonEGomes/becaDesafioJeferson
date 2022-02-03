package com.becaJavaJeferson.dtos.requests.patch;

import java.time.LocalDate;

public class PatchLocacaoRequest {
    private LocalDate dataAluguel;
    private LocalDate dataDevolve;

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
