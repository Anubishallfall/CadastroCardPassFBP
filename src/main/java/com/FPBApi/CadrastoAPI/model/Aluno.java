package com.FPBApi.CadrastoAPI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Aluno {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,  generator = "aluno_seq")
	@SequenceGenerator(name="aluno_seq", sequenceName = "aluno_seq", allocationSize=1)
	private Long id;
	
	private String nome;
	
	private String periodo;
	
	private String matricula;
	
	@ManyToOne
	@JoinColumn(name = "curso_id", referencedColumnName = "id", nullable = false)
	private Curso curso;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
	
}
