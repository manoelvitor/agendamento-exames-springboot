package com.projeto.utils;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.projeto.model.AgendaExame;
import com.projeto.repository.AgendaExameRepository;

public class DummyData {
	
	@Autowired
	private AgendaExameRepository repository;
	
	public void mockData() {
		List<AgendaExame> examesList = new ArrayList<>();
		AgendaExame exame1 = new AgendaExame();
		exame1.setNomePaciente("Maria Antonia da Silva");
	
		
	}
}
