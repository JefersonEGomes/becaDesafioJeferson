package com.becaJavaJeferson.services;

import com.becaJavaJeferson.model.Locador;

import java.util.List;

public interface LocadorService {

    Locador criar (Locador locador);

    List<Locador> listar();

    Locador obter (Integer id);

    Locador atualizar(Locador locador, Integer id);

    void deletar(Integer id);
}
