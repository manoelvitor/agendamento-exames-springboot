package com.projeto.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.model.AgendaExame;
import com.projeto.repository.AgendaExameRepository;

@Service
public class AgendaExameService implements ServiceInterface<AgendaExame> {

	@Autowired
	private AgendaExameRepository repository;

	@Override
	public List<AgendaExame> findAll() {
		return repository.findAll();
	}

	@Override
	public boolean create(AgendaExame obj) {
		if (repository.save(obj) != null)
			return true;
		return false;
	}

	@Override
	public Optional<AgendaExame> getId(Long id) {
		if (repository.existsById(id))
			return repository.findById(id);
		return null;
	}

	@Override
	public void delete(Long id) {
		if (repository.existsById(id))
			repository.deleteById(id);
	}

	@Override
	public AgendaExame update(AgendaExame obj) {
		if (obj.getId() != null) {
			repository.save(obj);
			return obj;
		}
		return null;
	}
	
	public List<AgendaExame> listarPorNomeExame(String nomeExame) {
		return repository.listarPorNomeExame(nomeExame);
	}

	public List<AgendaExame> listarPorNomePaciente(String nomePaciente) {
		return repository.listarPorNomePaciente(nomePaciente); 
	}
}
