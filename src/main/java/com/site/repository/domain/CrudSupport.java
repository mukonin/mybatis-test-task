package com.site.repository.domain;

import com.site.model.domain.AbstractIdentifiable;

import java.util.List;

public interface CrudSupport<T extends AbstractIdentifiable> {

	List<T> findAll();

	T getById(Integer id);

	void create(T model);

	void update(T model);

	void delete(Integer id);
}