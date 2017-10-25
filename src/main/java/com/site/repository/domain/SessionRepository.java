package com.site.repository.domain;

import com.site.mapper.domain.SessionMapper;
import com.site.model.domain.Session;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class SessionRepository extends BaseRepository<Session, SessionMapper> implements CrudRepository<Session> {

	public SessionRepository(SqlSessionFactory sessionFactory) {
		super(sessionFactory, SessionMapper.class);
	}
}