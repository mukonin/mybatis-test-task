package com.site.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Report {

	Integer requestId;
	String url;
	String method;
	String params;
	Integer sessionId;
	String userName;
	String countryName;
}