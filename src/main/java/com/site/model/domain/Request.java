package com.site.model.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Request extends AbstractIdentifiable {

	private String url;
	private String method;
	private String params;
	private Integer sessionId;
}