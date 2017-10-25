package com.site.service.domain;

import com.site.model.domain.Session;
import com.site.repository.domain.SessionRepository;
import org.springframework.stereotype.Service;

@Service
public class SessionService extends BaseService<SessionRepository, Session> implements CrudService<Session> {

	public SessionService(SessionRepository repository) {
		super(repository);
	}
}