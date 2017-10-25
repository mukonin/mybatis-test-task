package com.site.repository.domain;

import com.site.mapper.domain.LocationMapper;
import com.site.model.domain.Location;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class LocationRepository extends BaseRepository<Location, LocationMapper> implements CrudRepository<Location> {

	public LocationRepository(SqlSessionFactory sessionFactory) {
		super(sessionFactory, LocationMapper.class);
	}
}