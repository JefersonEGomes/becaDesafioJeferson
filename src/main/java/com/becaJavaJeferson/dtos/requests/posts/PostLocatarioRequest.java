package com.becaJavaJeferson.dtos.requests.posts;

import lombok.Data;

import javax.validation.constraints.Negative;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PostLocatarioRequest {


    @NotBlank(message = "O seu nome está vazio, por favor digite um nome válido")
    @Size(min = 3, message = "O seu nome não pode ter menos que 4 caracteres")
    private String nome;

    @NotBlank(message = "A sua idade está vazia, por favor digite uma idade válida")
    @Negative(message = "Sua idade não pode ser negativa")
    private Integer idade;

//    @NotBlank(message = "Seu CPF está vazio, por favor digite um CPF válido")
//    @Size(min = 11 ,max = 11, message = "Por favor digite um CPF válido")
//    @Negative(message = "Seu CPF não pode ser negativo")
    private Long cpf;

//    @NotBlank(message = "Seu telefone está vazio, por favor digite um telefone válido")
//    @Negative(message = "Seu telefone não pode ser negativo")
    private Long telefone;





}
