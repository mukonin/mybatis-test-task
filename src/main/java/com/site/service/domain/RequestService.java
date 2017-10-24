package com.site.service.domain;

import com.site.dao.domain.RequestDAO;
import com.site.model.entity.Request;
import org.springframework.stereotype.Service;

@Service
public class RequestService extends BaseService<Request> {

	public RequestService(RequestDAO repository) {
		super(repository);
	}
}