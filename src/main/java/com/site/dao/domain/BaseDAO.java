package com.site.dao.domain;

import com.site.model.entity.AbstractIdentifiable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BaseDAO<E extends AbstractIdentifiable, I extends Serializable> {

	private SessionFactory sessionFactory;
	private Class<E> type;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	protected BaseDAO() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		this.type = (Class<E>) pt.getActualTypeArguments()[0];
	}

	public I save(E entity) {
		return (I) getSession().save(entity);
	}

	public void delete(E entity) {
		getSession().delete(entity);
	}

	public void update(E entity) {
		getSession().update(entity);
	}

	public E getById(I id) {
		return getSession().get(type, id);
	}
}
