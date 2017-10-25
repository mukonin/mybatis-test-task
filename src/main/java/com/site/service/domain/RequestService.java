package com.site.service.domain;

import com.site.model.domain.Request;
import com.site.repository.domain.RequestRepository;
import org.springframework.stereotype.Service;

@Service
public class RequestService extends BaseService<RequestRepository, Request> implements CrudService<Request> {

	public RequestService(RequestRepository repository) {
		super(repository);
	}
}