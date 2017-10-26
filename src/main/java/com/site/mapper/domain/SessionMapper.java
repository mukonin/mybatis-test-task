package com.site.mapper.domain;

import com.site.model.domain.Session;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SessionMapper extends CrudMapper<Session> {

	@Select("SELECT * FROM sessions")
	@Results({
			@Result(property = "userId", column = "user_id"),
			@Result(property = "dateOpened", column = "date_opened"),
			@Result(property = "dateClosed", column = "date_closed")
	})
	List<Session> findAll();

	@Select("SELECT * FROM sessions WHERE id = #{id}")
	@Results({
			@Result(property = "userId", column = "user_id"),
			@Result(property = "dateOpened", column = "date_opened"),
			@Result(property = "dateClosed", column = "date_closed")
	})
	Session findById(Integer id);

	@Insert("INSERT INTO sessions (user_id, date_opened, date_closed) VALUES (#{userId}, #{dateOpened}, #{dateClosed})")
	@Options(useGeneratedKeys=true, keyColumn = "id")
	void create(Session session);

	@Update("UPDATE sessions SET user_id = #{userId}, date_opened = #{dateOpened}, date_closed = #{dateClosed} WHERE id = #{id}")
	void update(Session session);

	@Delete("DELETE FROM sessions WHERE id=#{id}")
	void delete(Integer id);
}