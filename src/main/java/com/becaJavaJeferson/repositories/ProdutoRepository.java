package com.becaJavaJeferson.repositories;

import com.becaJavaJeferson.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
