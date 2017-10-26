package com.site.repository.domain;

import com.site.mapper.domain.CrudMapper;
import com.site.model.domain.AbstractIdentifiable;
import lombok.AllArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

@AllArgsConstructor
public abstract class BaseRepository<T extends AbstractIdentifiable, M extends CrudMapper> implements CrudRepository<T> {

	protected final SqlSessionFactory sessionFactory;
	protected final Class<M> type;

	public List findAll() {
		try (SqlSession session = sessionFactory.openSession()) {
			M mapper = session.getMapper(type);
			List result = mapper.findAll();
			session.close();
			return result;
		}
	}

	public T findById(Integer id) {
		try (SqlSession session = sessionFactory.openSession()) {
			M mapper = session.getMapper(type);
			T result = (T) mapper.findById(id);
			session.close();
			return result;
		}
	}

	public void create(T model) {
		try (SqlSession session = sessionFactory.openSession()) {
			M mapper = session.getMapper(type);
			mapper.create(model);
			session.commit();
			session.close();
		}
	}

	public void update(T model) {
		try (SqlSession session = sessionFactory.openSession()) {
			M mapper = session.getMapper(type);
			mapper.update(model);
			session.commit();
			session.close();
		}
	}

	public void delete(Integer id) {
		try (SqlSession session = sessionFactory.openSession()) {
			M mapper = session.getMapper(type);
			mapper.delete(id);
			session.commit();
			session.close();
		}
	}
}