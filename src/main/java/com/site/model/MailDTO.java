package com.site.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MailDTO {

	private String from;
	private String[] to;
	private String subject;
	private String body;
	private String attachmentName;
	private byte[] attachment;
}