package com.becaJavaJeferson.dtos.requests.posts;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class PostLocatarioRequest {


    @NotBlank(message = "O seu nome está vazio, por favor digite um nome válido")
    @Size(min = 3, message = "O seu nome não pode ter menos que 4 caracteres")
    private String nome;

    @Positive
    @Min(value = 18, message = "Você não pode ser menor de 18 anos")
    private Integer idade;

    @NotBlank(message = "O seu cpf está vazio, por favor digite um nome válido")
    @Size(min = 11,max= 11, message = "O seu nome não pode ter menos/mais que 11 caracteres")
    private String cpf;

    @NotBlank(message = "O seu telefone está vazio, por favor digite um nome válido")
    private String telefone;





}
