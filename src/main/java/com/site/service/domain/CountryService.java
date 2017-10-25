package com.site.service.domain;

import com.site.model.domain.Country;
import com.site.repository.domain.CountryRepository;
import org.springframework.stereotype.Service;

@Service
public class CountryService extends BaseService<CountryRepository, Country> implements CrudService<Country> {

	public CountryService(CountryRepository repository) {
		super(repository);
	}
}