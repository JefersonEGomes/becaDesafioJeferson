package com.becaJavaJeferson.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

        public Locatario() {
        }

        /*protected boolean canEqual(final Object other) {
                return other instanceof Locatario;
        }*/

}

