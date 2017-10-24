package com.site.model.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class Location extends AbstractIdentifiable {

	private String locationName;
	private Integer countryId;
	private BigDecimal latitude;
	private BigDecimal longitude;
}