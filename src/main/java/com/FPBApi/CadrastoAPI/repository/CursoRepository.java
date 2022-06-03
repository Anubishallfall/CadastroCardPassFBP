package com.FPBApi.CadrastoAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FPBApi.CadrastoAPI.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}