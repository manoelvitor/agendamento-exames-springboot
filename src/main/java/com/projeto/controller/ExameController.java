package com.projeto.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projeto.model.Exame;
import com.projeto.service.ExameService;

@Controller
@RequestMapping(value = "/exames")
public class ExameController implements ControllerInterface<Exame> {

	@Autowired
	private ExameService service;

	@Override
	@GetMapping
	public ResponseEntity<List<Exame>> getAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Exame>> getById(@PathVariable("id") Long id) {
		if (service.getId(id) != null)
			return ResponseEntity.ok(service.getId(id));
		return ResponseEntity.notFound().build();
	}

	@Override
	@PostMapping
	public ResponseEntity<Exame> post(@Valid @RequestBody Exame obj) {
		service.create(obj);
		return ResponseEntity.ok(obj);
	}

	@Override
	@PutMapping
	public ResponseEntity<?> put(@Valid @RequestBody Exame obj) {
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

}
