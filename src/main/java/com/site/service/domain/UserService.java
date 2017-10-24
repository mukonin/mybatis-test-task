package com.site.service.domain;

import com.site.dao.domain.UserDAO;
import com.site.model.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User> {

	public UserService(UserDAO repository) {
		super(repository);
	}
}