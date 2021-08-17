package com.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.model.Exame;
import com.projeto.repository.ExameRepository;

@Service
public class ExameService implements ServiceInterface<Exame> {

	@Autowired
	private ExameRepository repository;

	@Override
	public List<Exame> findAll() {
		return repository.findAll();
	}

	@Override
	public boolean create(Exame obj) {
		if(repository.save(obj) != null)
			return true;
		return false;
	}
	
	@Override
	public Optional<Exame> getId(Long id) {
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
	public Exame update(Exame obj) {
		if(obj.getId() != null)
			return repository.save(obj);
		return null;
	}

}
