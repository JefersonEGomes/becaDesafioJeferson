package com.becaJavaJeferson.repositories;

import com.becaJavaJeferson.model.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Integer> {

//    Locacao criar(Locacao locacao);
//
//    List<Locacao> listar();
//
//    Locacao obter(Integer id);
//
//    Locacao atualizar(Locacao locacao,Integer id);
//
//    void deletar(Integer id);
}
