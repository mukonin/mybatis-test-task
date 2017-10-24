package com.site.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table
@Setter
@Getter
public class Location extends AbstractIdentifiable {

	@Column(columnDefinition = "VARCHAR(50)")
	private String locationName;

	@ManyToOne
	@JoinColumn
	private Country country;

	@Column
	private BigDecimal latitude;

	@Column
	private BigDecimal longitude;
}