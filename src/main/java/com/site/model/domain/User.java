package com.site.model.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User extends AbstractIdentifiable {

	private String userName;
	private Integer locationId;
	private Integer userGroupId;
}