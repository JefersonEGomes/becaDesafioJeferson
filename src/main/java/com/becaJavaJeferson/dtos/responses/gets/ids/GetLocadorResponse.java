package com.becaJavaJeferson.dtos.responses.gets.ids;

import lombok.Data;

@Data
public class GetLocadorResponse {
    private Integer id;
    private String nome;
    private Integer idade;
    private String cpf;
    private String telefone;

}
