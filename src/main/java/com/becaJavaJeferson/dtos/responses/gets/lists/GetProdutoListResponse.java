package com.becaJavaJeferson.dtos.responses.gets.lists;

import com.becaJavaJeferson.dtos.responses.posts.PostLocadorResponseCustom;
import lombok.Data;

@Data
public class GetProdutoListResponse {

    private String nome;
    private String categoria;
    private PostLocadorResponseCustom locador;

}
