package com.site.service.domain;

import com.site.model.domain.UserGroup;
import com.site.repository.domain.UserGroupRepository;
import org.springframework.stereotype.Service;

@Service
public class UserGroupService extends BaseService<UserGroupRepository, UserGroup> implements CrudService<UserGroup> {

	public UserGroupService(UserGroupRepository repository) {
		super(repository);
	}
}