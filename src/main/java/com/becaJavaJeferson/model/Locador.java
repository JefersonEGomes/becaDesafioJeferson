package com.becaJavaJeferson.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Locador{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Integer idade;
    private String cpf;
    private String telefone;

    public Locador() {
    }


   /* protected boolean canEqual(final Object other) {
        return other instanceof Locador;
    }*/

}
