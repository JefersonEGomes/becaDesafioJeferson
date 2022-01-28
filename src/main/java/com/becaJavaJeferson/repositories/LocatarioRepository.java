package com.becaJavaJeferson.repositories;

import com.becaJavaJeferson.model.Locacao;
import com.becaJavaJeferson.model.Locatario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocatarioRepository extends JpaRepository<Locatario, Integer> {


}
