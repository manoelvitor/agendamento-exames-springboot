package com.projeto.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projeto.model.AgendaExame;
import com.projeto.service.AgendaExameService;

@RestController
@RequestMapping("/agenda")
public class AgendaExameController implements ControllerInterface<AgendaExame> {
	@Autowired
	private AgendaExameService service;

	@Override
	@GetMapping
	public ResponseEntity<List<AgendaExame>> getAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Optional<AgendaExame>> getById(@PathVariable("id") Long id) {
		if (service.getId(id) != null)
			return ResponseEntity.ok(service.getId(id));
		return ResponseEntity.notFound().build();
	}

	@Override
	@PostMapping
	public ResponseEntity<AgendaExame> post(@Valid @RequestBody AgendaExame obj) {
		if (service.create(obj))
			return ResponseEntity.ok(obj);
		return ResponseEntity.notFound().build();
	}

	@Override
	@PutMapping
	public ResponseEntity<?> put(@Valid @RequestBody AgendaExame obj) {
		if (service.getId(obj.getId()) != null) {
			return ResponseEntity.ok(service.create(obj));
		}
		return ResponseEntity.badRequest().body("Paciente ou exame não encontrado");
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (service.getId(id) != null) {
			service.delete(id);
			return ResponseEntity.ok("Deletado com sucesso");
		}
		return ResponseEntity.badRequest().body("Paciente ou exame não encontrado");
	}
	
	
	@GetMapping("/listarNomeExame/{nomeExame}")
	public ResponseEntity<List<AgendaExame>> listarPorNomeExame(@PathVariable("nomeExame") String nomeExame) {
		return ResponseEntity.ok(service.listarPorNomeExame(nomeExame));
	}
	
	@GetMapping("/listarNomePaciente/{nomePaciente}")
	public ResponseEntity<List<AgendaExame>> listarPorNomePaciente(@PathVariable("nomePaciente") String nomePaciente) {
		return ResponseEntity.ok(service.listarPorNomePaciente(nomePaciente));
	}
	

}
