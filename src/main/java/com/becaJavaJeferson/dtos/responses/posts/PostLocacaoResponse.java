package com.becaJavaJeferson.dtos.responses.posts;

import lombok.Data;

@Data
public class PostLocacaoResponse {
    private String mensagem;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
