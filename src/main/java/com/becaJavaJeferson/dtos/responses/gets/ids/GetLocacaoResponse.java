package com.becaJavaJeferson.dtos.responses.gets.ids;

import lombok.*;

import java.time.LocalDate;


@Data
public class GetLocacaoResponse {

    private LocalDate dataAluguel;
    private LocalDate dataDevolve;
    private GetLocatarioResponse locatario;
    private GetProdutoResponse produto;

}
