package com.becaJavaJeferson.repository;

import java.util.List;

public interface InterfaceMeEmpresta<I> {
    I criar (I item);
    I atualizar (I item, Integer id);
    void deletar (Integer id);
    List<I> listar();
    I obter (Integer id);
}
