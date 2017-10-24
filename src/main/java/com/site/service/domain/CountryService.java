package com.site.service.domain;

import com.site.dao.domain.CountryDAO;
import com.site.model.entity.Country;
import org.springframework.stereotype.Service;

@Service
public class CountryService extends BaseService<Country> {

	public CountryService(CountryDAO repository) {
		super(repository);
	}
}