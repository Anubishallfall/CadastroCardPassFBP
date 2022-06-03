package com.FPBApi.CadrastoAPI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Curso {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,  generator = "curso_seq")
	@SequenceGenerator(name="curso_seq", sequenceName = "curso_seq", allocationSize=1)
	private Long id;
	
	private String nome;
	
	private String tipo;

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
}
