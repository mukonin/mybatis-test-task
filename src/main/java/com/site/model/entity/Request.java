package com.site.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
@Setter
@Getter
public class Request extends AbstractIdentifiable {

	@Column(columnDefinition = "VARCHAR(100)")
	private String url;

	@Column(columnDefinition = "VARCHAR(10)")
	private String method;

	@Column(columnDefinition = "TEXT(100)")
	private String params;

	@ManyToOne
	@JoinColumn
	private Session session;
}