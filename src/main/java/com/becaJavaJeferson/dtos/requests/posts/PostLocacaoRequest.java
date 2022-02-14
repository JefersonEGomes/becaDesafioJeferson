package com.becaJavaJeferson.dtos.requests.posts;

import com.becaJavaJeferson.dtos.responses.gets.ids.GetLocatarioResponse;
import com.becaJavaJeferson.dtos.responses.gets.ids.GetProdutoResponse;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PostLocacaoRequest {

    private LocalDate dataAluguel;

    private LocalDate dataDevolve;


    private GetLocatarioResponse locatario;


    private GetProdutoResponse produto;


}
