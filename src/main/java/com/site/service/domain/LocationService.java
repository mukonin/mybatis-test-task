package com.site.service.domain;

import com.site.model.domain.Location;
import com.site.repository.domain.LocationRepository;
import org.springframework.stereotype.Service;

@Service
public class LocationService extends BaseService<LocationRepository, Location> implements CrudService<Location> {

	public LocationService(LocationRepository repository) {
		super(repository);
	}
}