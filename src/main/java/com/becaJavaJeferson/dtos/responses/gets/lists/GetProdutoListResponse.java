package com.becaJavaJeferson.dtos.responses.gets.lists;

import com.becaJavaJeferson.dtos.requests.posts.PostLocadorRequest;
import lombok.Data;

@Data
public class GetProdutoListResponse {

    private String nome;
    private String categoria;
    private PostLocadorRequest locador;

}
