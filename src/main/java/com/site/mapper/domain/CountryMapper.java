package com.site.mapper.domain;

import com.site.model.domain.Country;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CountryMapper {

	@Select("SELECT * FROM country")
	@Results({
			@Result(property = "countryName", column = "country_name")
	})
	List<Country> findAll();

	@Select("SELECT * FROM country WHERE id = #{id}")
	@Results({
			@Result(property = "countryName", column = "country_name")
	})
	Country findById(Integer id);

	@Insert("INSERT INTO country (country_name, language) VALUES (#{countryName}, #{language})")
	void create(Country country);

	@Update("UPDATE country SET country_name = #{countryName}, language = #{language} WHERE id = #{id}")
	void update(Country country);

	@Delete("DELETE FROM country WHERE id=#{id}")
	void delete(Integer id);
}