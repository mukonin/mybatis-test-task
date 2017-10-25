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
		try (SqlSession sqlSession = sessionFactory.openSession()) {
			M mapper = sqlSession.getMapper(type);
			return mapper.findAll();
		}
	}

	public T findById(Integer id) {
		try (SqlSession sqlSession = sessionFactory.openSession()) {
			M mapper = sqlSession.getMapper(type);
			return (T) mapper.findById(id);
		}
	}

	public void create(T model) {
		try (SqlSession sqlSession = sessionFactory.openSession()) {
			M mapper = sqlSession.getMapper(type);
			mapper.create(model);
		}
	}

	public void update(T model) {
		try (SqlSession sqlSession = sessionFactory.openSession()) {
			M mapper = sqlSession.getMapper(type);
			mapper.update(model);
		}
	}

	public void delete(Integer id) {
		try (SqlSession sqlSession = sessionFactory.openSession()) {
			M mapper = sqlSession.getMapper(type);
			mapper.delete(id);
		}
	}
}