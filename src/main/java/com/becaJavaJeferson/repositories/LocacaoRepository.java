package com.becaJavaJeferson.repositories;

import com.becaJavaJeferson.model.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Integer> {


}
