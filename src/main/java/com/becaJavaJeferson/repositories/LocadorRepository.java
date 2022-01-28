package com.becaJavaJeferson.repositories;

import com.becaJavaJeferson.model.Locacao;
import com.becaJavaJeferson.model.Locador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocadorRepository extends JpaRepository<Locador, Integer> {

}
