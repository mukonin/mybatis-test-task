package com.site.service.domain;

import com.site.dao.BaseDAO;
import com.site.model.entity.AbstractIdentifiable;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class BaseService<E extends AbstractIdentifiable> {

	private BaseDAO<E, Integer> repository;

	public Integer save(E entity) {
		return repository.save(entity);
	}

	public void delete(E entity) {
		repository.delete(entity);
	}

	public void update(E entity) {
		repository.update(entity);
	}

	public E getById(Integer id) {
		return repository.getById(id);
	}
}