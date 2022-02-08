package com.becaJavaJeferson.dtos.responses.patch;

import lombok.Data;

@Data
public class PatchLocadorResponse {

    private Integer id;
    private String nome;
    private Integer idade;
    private Long cpf;
    private Long telefone;
    private String mensagem;
}
