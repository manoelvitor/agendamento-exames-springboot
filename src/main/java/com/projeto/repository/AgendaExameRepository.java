package com.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projeto.model.AgendaExame;


@Repository
public interface AgendaExameRepository extends JpaRepository<AgendaExame, Long> {
	
	@Query("select e from AgendaExame e where e.nomeExame.nomeExame=?1")
	List<AgendaExame> listarPorNomeExame(String nomeExame);
	
	@Query("select e from AgendaExame e where e.nomePaciente=?1")
	List<AgendaExame> listarPorNomePaciente(String nomePaciente);
	
	
	
}
