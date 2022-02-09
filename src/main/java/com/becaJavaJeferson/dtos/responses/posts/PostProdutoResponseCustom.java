package com.becaJavaJeferson.dtos.responses.posts;

import lombok.Data;

@Data
public class PostProdutoResponseCustom {
    private String nome;
    private PostLocadorResponseCustom locador;
}
