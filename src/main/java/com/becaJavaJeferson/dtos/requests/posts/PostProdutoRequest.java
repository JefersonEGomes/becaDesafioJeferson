package com.becaJavaJeferson.dtos.requests.posts;

import com.becaJavaJeferson.model.Produto;
import lombok.Data;

import javax.validation.constraints.Negative;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PostProdutoRequest {

    @NotBlank(message = "O nome está vazio, por favor digite um nome válido")
    @Size(min = 3, message = "O nome do produto não pode ter menos que 4 caracteres")
    private String nome;

    @NotBlank(message = "O nome da categoria está vazio, por favor digite um nome válido")
    @Size(min = 3, message = "O nome da categoria não pode ter menos que 4 caracteres")
    private String categoria;

    private Double preco;

    private PostLocadorRequest locador;

}
