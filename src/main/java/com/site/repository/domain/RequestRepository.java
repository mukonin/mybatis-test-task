package com.site.repository.domain;

import com.site.mapper.domain.RequestMapper;
import com.site.model.domain.Request;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class RequestRepository extends BaseRepository<Request, RequestMapper> implements CrudRepository<Request> {

	public RequestRepository(SqlSessionFactory sessionFactory) {
		super(sessionFactory, RequestMapper.class);
	}
}