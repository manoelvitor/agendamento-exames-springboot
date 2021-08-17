package com.projeto.service;

import java.util.List;
import java.util.Optional;


public interface ServiceInterface<T> {

	List<T> findAll();

	boolean create(T obj);

	Optional<T> getId(Long id);

	T update(T obj);

	void delete(Long id);

}
