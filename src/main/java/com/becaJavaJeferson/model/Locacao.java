package com.becaJavaJeferson.model;

import lombok.Data;

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



}


