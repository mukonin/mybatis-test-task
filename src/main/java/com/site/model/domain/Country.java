package com.site.model.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Country extends AbstractIdentifiable {

	private String countryName;
	private String language;
}