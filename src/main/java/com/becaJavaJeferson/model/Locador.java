package com.becaJavaJeferson.model;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Entity;

@Data
@Entity
public class Locador{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Integer idade;
    private Long cpf;
    private Long telefone;




}
