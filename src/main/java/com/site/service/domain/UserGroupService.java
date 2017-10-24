package com.site.service.domain;

import com.site.dao.UserGroupDAO;
import com.site.model.entity.UserGroup;
import org.springframework.stereotype.Service;

@Service
public class UserGroupService extends BaseService<UserGroup> {

	public UserGroupService(UserGroupDAO repository) {
		super(repository);
	}
}