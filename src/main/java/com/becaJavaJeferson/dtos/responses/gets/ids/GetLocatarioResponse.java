package com.becaJavaJeferson.dtos.responses.gets.ids;

import lombok.Data;

@Data
public class GetLocatarioResponse {
    private Integer id;
    private String nome;
    private Integer idade;
    private Long cpf;
    private Long telefone;

}
