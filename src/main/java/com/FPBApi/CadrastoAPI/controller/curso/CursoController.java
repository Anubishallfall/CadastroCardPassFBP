package com.FPBApi.CadrastoAPI.controller.curso;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.FPBApi.CadrastoAPI.model.Curso;
import com.FPBApi.CadrastoAPI.repository.CursoRepository;

@RestController
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	CursoRepository cursoRepository;

	@PostMapping("")
	public ResponseEntity<Curso> store(@RequestBody @Validated Curso curso, UriComponentsBuilder uriBuilder)
			throws Exception {
		
		Curso cursoSalvo = cursoRepository.save(curso);
		
		URI uri = uriBuilder.path("/curso/{id}").buildAndExpand(cursoSalvo.getId()).toUri();
		return ResponseEntity.created(uri).body(cursoSalvo);
	}
	@GetMapping("")
	public List<Curso> buscar(){	
	List<Curso> cursos = cursoRepository.findAll();
		return cursos;
	}
}
