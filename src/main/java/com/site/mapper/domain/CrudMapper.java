package com.site.mapper.domain;

import com.site.common.CrudSupport;
import com.site.model.domain.AbstractIdentifiable;

public interface CrudMapper<T extends AbstractIdentifiable> extends CrudSupport<T> {
}