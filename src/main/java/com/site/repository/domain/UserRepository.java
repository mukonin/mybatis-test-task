package com.site.repository.domain;

import com.site.mapper.domain.UserMapper;
import com.site.model.domain.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends BaseRepository<User, UserMapper> implements CrudRepository<User> {

	public UserRepository(SqlSessionFactory sessionFactory) {
		super(sessionFactory, UserMapper.class);
	}
}