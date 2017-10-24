package com.site.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@Setter
@Getter
public class UserGroup extends AbstractIdentifiable {

	@Column(columnDefinition = "VARCHAR(50)")
	private String groupName;
}