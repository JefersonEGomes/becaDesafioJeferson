package com.becaJavaJeferson.services;

import com.becaJavaJeferson.model.Locatario;

import java.util.List;

public interface LocatarioService {

    Locatario criar (Locatario Locatario);

    List<Locatario> listar();

    Locatario obter (Integer id);

    Locatario atualizar(Locatario locatario, Integer id);

    void deletar(Integer id);
}
