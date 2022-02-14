package com.becaJavaJeferson.dtos.requests.patch;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PatchLocacaoRequest {
    private LocalDate dataAluguel;
    private LocalDate dataDevolve;

}
