package com.becaJavaJeferson.dtos.requests.patch;

import lombok.Data;

@Data
public class PatchProdutoRequest {
    private String nome;
    private String categoria;
    private Double preco;

}
