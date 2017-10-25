package com.site.mapper.domain;

import com.site.model.domain.UserGroup;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserGroupMapper extends CrudMapper<UserGroup> {

	@Select("SELECT * FROM user_group")
	@Results({
			@Result(property = "groupName", column = "group_name")
	})
	List<UserGroup> findAll();

	@Select("SELECT * FROM user_group WHERE id = #{id}")
	@Results({
			@Result(property = "groupName", column = "group_name")
	})
	UserGroup findById(Integer id);

	@Insert("INSERT INTO user_group (group_name) VALUES (#{groupName})")
	void create(UserGroup userGroup);

	@Update("UPDATE user_group SET group_name = #{groupName} WHERE id = #{id}")
	void update(UserGroup userGroup);

	@Delete("DELETE FROM user_group WHERE id=#{id}")
	void delete(Integer id);
}