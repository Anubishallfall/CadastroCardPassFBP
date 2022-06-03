package com.FPBApi.CadrastoAPI.controller.aluno;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.FPBApi.CadrastoAPI.model.Aluno;
import com.FPBApi.CadrastoAPI.model.Curso;
import com.FPBApi.CadrastoAPI.repository.AlunoRepository;
import com.FPBApi.CadrastoAPI.repository.CursoRepository;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	CursoRepository cursoRepository;

	@Autowired
	AlunoRepository alunoRepository;

	@PostMapping("")
	public ResponseEntity<Aluno> store(@RequestBody @Validated Aluno aluno, UriComponentsBuilder uriBuilder)
			throws Exception {
		Optional<Curso> curso = cursoRepository.findById(aluno.getCurso().getId());
		if (curso.isPresent()) {

			aluno.setCurso(curso.get());
			Aluno alunoSalvo = alunoRepository.save(aluno);

			URI uri = uriBuilder.path("/aluno/{id}").buildAndExpand(alunoSalvo.getId()).toUri();
			return ResponseEntity.created(uri).body(alunoSalvo);
		}
		return ResponseEntity.ok(null);
	}

	@GetMapping("")
	public List<Aluno> buscar() {

		List<Aluno> alunos = alunoRepository.findAll();

		return alunos;

	}
	
	@PostMapping("/buscar")
	public ResponseEntity<Aluno> ex(@RequestBody @Validated Aluno aluno){
	Optional<Aluno> alunoFIND = alunoRepository.findById(aluno.getId());
	
	if(alunoFIND.isPresent()) {
		Aluno alunoDoBanco = alunoFIND.get();
		return ResponseEntity.ok().body(alunoDoBanco);
	}
	
		return ResponseEntity.ok(null);
	}


}
