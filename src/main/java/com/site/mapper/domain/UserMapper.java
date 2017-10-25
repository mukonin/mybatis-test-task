package com.site.mapper.domain;

import com.site.model.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper extends CrudMapper<User> {

	@Select("SELECT * FROM user")
	@Results({
			@Result(property = "userName", column = "user_name"),
			@Result(property = "locationId", column = "location_id"),
			@Result(property = "userGroupId", column = "user_group_id")
	})
	List<User> findAll();

	@Select("SELECT * FROM user WHERE id = #{id}")
	@Results({
			@Result(property = "userName", column = "user_name"),
			@Result(property = "locationId", column = "location_id"),
			@Result(property = "userGroupId", column = "user_group_id")
	})
	User findById(Integer id);

	@Insert("INSERT INTO user (user_name, location_id, user_group_id) VALUES (#{userName}, #{locationId}, #{userGroupId})")
	void create(User user);

	@Update("UPDATE user SET user_name = #{userName}, location_id = #{locationId}, user_group_id = #{userGroupId} WHERE id = #{id}")
	void update(User user);

	@Delete("DELETE FROM user WHERE id=#{id}")
	void delete(Integer id);
}