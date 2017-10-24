package com.site.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Setter
@Getter
public class User extends AbstractIdentifiable {

	@Column
	private String userName;

	@ManyToOne
	@JoinColumn
	private Location location;

	@ManyToOne
	@JoinColumn
	private UserGroup userGroup;
}