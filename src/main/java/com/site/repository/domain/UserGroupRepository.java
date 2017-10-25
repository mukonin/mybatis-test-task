package com.site.repository.domain;

import com.site.mapper.domain.UserGroupMapper;
import com.site.model.domain.UserGroup;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserGroupRepository extends BaseRepository<UserGroup, UserGroupMapper> implements  CrudRepository<UserGroup> {

	public UserGroupRepository(SqlSessionFactory sessionFactory) {
		super(sessionFactory, UserGroupMapper.class);
	}
}