package com.site.model.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class Session extends AbstractIdentifiable {

	private Integer userId;
	private LocalDateTime dateOpened;
	private LocalDateTime dateClosed;
}