package com.site.repository.domain;

import com.site.mapper.domain.CountryMapper;
import com.site.model.domain.Country;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CountryRepository extends BaseRepository<Country, CountryMapper> implements CrudRepository<Country> {

	public CountryRepository(SqlSessionFactory sessionFactory) {
		super(sessionFactory, CountryMapper.class);
	}
}