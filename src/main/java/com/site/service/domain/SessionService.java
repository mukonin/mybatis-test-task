package com.site.service.domain;

import com.site.dao.domain.SessionDAO;
import com.site.model.entity.Session;
import org.springframework.stereotype.Service;

@Service
public class SessionService extends BaseService<Session> {

	public SessionService(SessionDAO repository) {
		super(repository);
	}
}