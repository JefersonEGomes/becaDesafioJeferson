package com.becaJavaJeferson.dtos.responses.gets.ids;

import lombok.Data;

@Data
public class GetProdutoResponse {
    private Integer id;
    private String nome;
    private String categoria;
    private Double preco;
    private GetLocadorResponse locador;

}
