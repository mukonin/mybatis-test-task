package com.site.repository.domain;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseRepository {

	protected SqlSessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SqlSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
