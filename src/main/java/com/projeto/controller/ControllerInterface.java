package com.projeto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;




public interface ControllerInterface<T> {
	
	ResponseEntity<List<T>> getAll();
	
	ResponseEntity<Optional<T>> getById(Long id);
	
	ResponseEntity<T> post(T obj);
	
	ResponseEntity<?> put(T obj);

	ResponseEntity<?> delete(Long id);

}
