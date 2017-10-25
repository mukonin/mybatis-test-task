package com.site;

import com.site.model.domain.Country;
import com.site.service.domain.CountryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountryServiceTest {

	@Autowired
	private CountryService service;

	@Test
	public void testFindAll() {
		List<Country> countries = service.findAll();
		Assert.assertEquals(countries.size(), 196);
	}

	@Test
	public void crudTest() {
		Country country = new Country();
		country.setCountryName("TestCountry");
		country.setLanguage("TestCountryLanguage");
		service.create(country);
	}
}