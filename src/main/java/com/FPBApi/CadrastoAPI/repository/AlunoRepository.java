package com.FPBApi.CadrastoAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FPBApi.CadrastoAPI.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}