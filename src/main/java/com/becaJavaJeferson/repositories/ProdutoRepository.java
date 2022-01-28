package com.becaJavaJeferson.repositories;

import com.becaJavaJeferson.model.Locacao;
import com.becaJavaJeferson.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

//    Produto criar(Produto produto);
//
//    List<Produto> listar();
//
//    Produto obter(Integer id);
//
//    Produto atualizar(Produto produto, Integer id);
//
//    void deletar(Integer id);
}
