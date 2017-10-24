package com.site.mapper;

import com.site.model.Report;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ReportMapper {

	@Select("SELECT " +
			"request.id, " +
			"request.method, " +
			"request.params, " +
			"request.url, " +
			"request.session_id, " +
			"users.user_name, " +
			"country.country_name " +
			"FROM request " +
			"LEFT JOIN sessions ON request.session_id = sessions.id " +
			"LEFT JOIN users ON sessions.user_id = users.id " +
			"LEFT JOIN location ON users.location_id = location.id " +
			"LEFT JOIN country ON location.country_id = country.id " +
			"ORDER BY 7, 6")
	@Results({
			@Result(id = true, property = "requestId", column = "id"),
			@Result(property = "sessionId", column = "session_id"),
			@Result(property = "userName", column = "user_name"),
			@Result(property = "countryName", column = "country_name")
	})
	List<Report> getAll();
}