package com.becaJavaJeferson.dtos.requests.patch;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
public class PatchLocadorRequest {

    @NotBlank(message = "O seu nome está vazio, por favor digite um nome válido")
    @Size(min = 3, message = "O seu nome não pode ter menos que 4 caracteres")
    private String nome;

    @Positive
    @Min(value = 18, message = "Você não pode ser menor de 18 anos")
    private Integer idade;

    @NotBlank(message = "O Seu cpf está vazio, por favor digite um nome válido")
    @Size(min = 11,max= 11, message = "O seu nome não pode ter menos/mais que 11 caracteres")
    private String cpf;

    @NotBlank(message = "O Seu telefone está vazio, por favor digite um nome válido")
    private String telefone;

}
