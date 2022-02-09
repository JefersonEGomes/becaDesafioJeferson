package com.becaJavaJeferson.dtos.requests.posts;

import lombok.Data;

import javax.validation.constraints.Negative;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
public class PostLocatarioRequest {


    @NotBlank(message = "O seu nome está vazio, por favor digite um nome válido")
    @Size(min = 3, message = "O seu nome não pode ter menos que 4 caracteres")
    private String nome;

    @Positive
    private Integer idade;

    private Long cpf;

    private Long telefone;





}
