package com.becaJavaJeferson.dtos.requests.posts;

import com.becaJavaJeferson.dtos.responses.gets.ids.GetLocatarioResponse;
import com.becaJavaJeferson.dtos.responses.gets.ids.GetProdutoResponse;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
public class PostLocacaoRequest {

    @NotBlank(message = "A data de locação não pode estar vazia")
    @Past(message = "A data de locação não pode ser uma data inferior ao aluguel")
    private LocalDate dataAluguel;

    @NotBlank(message = "A data de devolução não pode estar vazia")
    @Past(message = "A data de devolução não pode ser uma data inferior ao aluguel")
    private LocalDate dataDevolve;

//    @NotBlank(message = "o Id do Locatario não pode estar vazio")
    private GetLocatarioResponse locatario;

//    @NotBlank(message = "o Id do Produto não pode estar vazio")
    private GetProdutoResponse produto;


}
