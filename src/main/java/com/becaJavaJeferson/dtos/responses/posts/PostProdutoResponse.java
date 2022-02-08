package com.becaJavaJeferson.dtos.responses.posts;

import com.becaJavaJeferson.dtos.requests.posts.PostLocadorRequest;
import com.becaJavaJeferson.model.Locador;
import lombok.Data;

@Data
public class PostProdutoResponse {
    private Integer id;
    private String mensagem;

}
