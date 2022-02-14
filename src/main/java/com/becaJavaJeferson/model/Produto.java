package com.becaJavaJeferson.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String categoria;
    private Double preco;

    @OneToOne
    private Locador locador;

    public Produto() {
    }


}
