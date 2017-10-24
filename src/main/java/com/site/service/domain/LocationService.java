package com.site.service.domain;

import com.site.dao.domain.LocationDAO;
import com.site.model.entity.Location;
import org.springframework.stereotype.Service;

@Service
public class LocationService extends BaseService<Location> {

	public LocationService(LocationDAO repository) {
		super(repository);
	}
}