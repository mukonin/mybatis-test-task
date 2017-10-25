package com.site.mapper.domain;

import com.site.model.domain.Request;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface RequestMapper {

	@Select("SELECT * FROM request")
	@Results({
			@Result(property = "sessionId", column = "session_id")
	})
	List<Request> getAll();

	@Select("SELECT * FROM request WHERE id = #{id}")
	@Results({
			@Result(property = "sessionId", column = "session_id")
	})
	Request findById(Integer id);

	@Insert("INSERT INTO request (url, method, params, session_id) " +
			"VALUES (#{url}, #{method}), #{params}), #{sessionId})")
	void create(Request request);

	@Update("UPDATE request SET url = #{url}, method = #{method}, " +
			"params = #{params}, session_id = #{sessionId} WHERE id = #{id}")
	void update(Request request);

	@Delete("DELETE FROM request WHERE id=#{id}")
	void delete(Integer id);
}