package com.site.mapper.domain;

import com.site.model.domain.Location;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface LocationMapper {

	@Select("SELECT * FROM location")
	@Results({
			@Result(property = "locationName", column = "location_name"),
			@Result(property = "countryId", column = "country_id")
	})
	List<Location> getAll();

	@Select("SELECT * FROM location WHERE id = #{id}")
	@Results({
			@Result(property = "locationName", column = "location_name"),
			@Result(property = "countryId", column = "country_id")
	})
	Location findById(Integer id);

	@Insert("INSERT INTO location (location_name, country_id, latitude, longitude) " +
			"VALUES (#{locationName}, #{countryId}, #{latitude}, #{longitude})")
	void create(Location location);

	@Update("UPDATE location SET location_name = #{locationName}, country_id = #{countryId}, " +
			"latitude = #{latitude}, longitude = #{longitude} WHERE id = #{id}")
	void update(Location location);

	@Delete("DELETE FROM location WHERE id=#{id}")
	void delete(Integer id);
}