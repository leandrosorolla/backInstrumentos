package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Instrumento;
@Repository
public interface InstrumentoRepository extends JpaRepository<Instrumento, Integer>{

}
