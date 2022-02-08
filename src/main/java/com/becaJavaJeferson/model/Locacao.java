package com.becaJavaJeferson.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Locacao {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate dataAluguel;
    private LocalDate dataDevolve;

    @ManyToOne
    private Locatario locatario;

    @OneToOne
    private Produto produto;

    public Locacao() {
    }


    /*protected boolean canEqual(final Object other) {
        return other instanceof Locacao;
    }*/

}


