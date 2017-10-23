package com.site.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table
@Setter
@Getter
public class Session extends AbstractIdentifiable {

	@ManyToOne
	@JoinColumn
	private User user;

	@Column(columnDefinition = "DATETIME")
	private LocalDateTime dateOpened;

	@Column(columnDefinition = "DATETIME")
	private LocalDateTime dateClosed;
}