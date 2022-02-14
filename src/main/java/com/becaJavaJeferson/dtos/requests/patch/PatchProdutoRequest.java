package com.becaJavaJeferson.dtos.requests.patch;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PatchProdutoRequest {

    @NotBlank(message = "O seu nome está vazio, por favor digite um nome válido")
    @Size(min = 3, message = "O seu nome não pode ter menos que 4 caracteres")
    private String nome;

    private String categoria;
    private Double preco;

}
