package com.becaJavaJeferson.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Locatario{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String nome;
        private Integer idade;
        private Long cpf;
        private Long telefone;

    }

