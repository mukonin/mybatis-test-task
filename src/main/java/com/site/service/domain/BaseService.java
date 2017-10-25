package com.site.service.domain;

import com.site.model.domain.AbstractIdentifiable;
import com.site.repository.domain.CrudRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public abstract class BaseService<R extends CrudRepository, T extends AbstractIdentifiable> implements CrudService<T> {

	protected final R repository;

	@Override
	public List<T> findAll() {
		return repository.findAll();
	}

	@Override
	public T findById(Integer id) {
		return (T) repository.findById(id);
	}

	@Override
	public void create(T model) {
		repository.create(model);
	}

	@Override
	public void update(T model) {
		repository.update(model);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}
}