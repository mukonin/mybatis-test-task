package com.site;

import com.site.model.domain.Country;
import com.site.service.domain.CountryService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CountryServiceTest {

	@Autowired
	private CountryService service;

	@Test
	public void test_1_findAll() {
		List<Country> countries = service.findAll();
		assertEquals(countries.size(), 196);
	}

	@Test
	public void test_2_crud() {
		Country country = new Country();
		country.setCountryName("TestCountry");
		country.setLanguage("TestCountryLanguage");
		service.create(country);

		assertNotNull(country.getId());

		Country created = service.findById(country.getId());
		assertEquals(country.getCountryName(), created.getCountryName());
		assertEquals(country.getLanguage(), created.getLanguage());

		country.setCountryName("NewCountry");
		country.setLanguage("NewLanguage");

		service.update(country);

		Country updated = service.findById(country.getId());
		assertEquals(country.getCountryName(), updated.getCountryName());
		assertEquals(country.getLanguage(), updated.getLanguage());

		service.delete(country.getId());

		Country deleted = service.findById(country.getId());
		assertEquals(null, deleted);
	}
}