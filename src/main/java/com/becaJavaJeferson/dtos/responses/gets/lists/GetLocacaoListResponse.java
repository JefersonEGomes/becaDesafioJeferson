package com.becaJavaJeferson.dtos.responses.gets.lists;

import com.becaJavaJeferson.dtos.requests.posts.PostLocatarioRequest;
import com.becaJavaJeferson.dtos.requests.posts.PostProdutoRequest;
import com.becaJavaJeferson.dtos.responses.posts.PostLocatarioResponseCustom;
import com.becaJavaJeferson.dtos.responses.posts.PostProdutoResponseCustom;
import lombok.Data;

import java.time.LocalDate;

@Data
public class GetLocacaoListResponse {

    private PostProdutoResponseCustom produto;
    private PostLocatarioResponseCustom locatario;
    private LocalDate dataAluguel;
    private LocalDate dataDevolve;

}
