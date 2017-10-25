package com.site.repository.domain;

import com.site.common.CrudSupport;
import com.site.model.domain.AbstractIdentifiable;

public interface CrudRepository<T extends AbstractIdentifiable> extends CrudSupport<T> {
}