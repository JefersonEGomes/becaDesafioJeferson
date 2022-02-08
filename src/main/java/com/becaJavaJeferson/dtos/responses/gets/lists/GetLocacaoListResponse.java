package com.becaJavaJeferson.dtos.responses.gets.lists;

import com.becaJavaJeferson.dtos.requests.posts.PostLocatarioRequest;
import com.becaJavaJeferson.dtos.requests.posts.PostProdutoRequest;
import lombok.Data;

import java.time.LocalDate;

@Data
public class GetLocacaoListResponse {

    private PostProdutoRequest produto;
    private PostLocatarioRequest locatario;
    private LocalDate dataAluguel;
    private LocalDate dataDevolve;

}
