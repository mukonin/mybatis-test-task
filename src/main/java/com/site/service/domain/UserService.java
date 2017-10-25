package com.site.service.domain;

import com.site.model.domain.User;
import com.site.repository.domain.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<UserRepository, User> implements CrudService<User> {

	public UserService(UserRepository repository) {
		super(repository);
	}
}