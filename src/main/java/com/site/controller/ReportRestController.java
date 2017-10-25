package com.site.controller;

import com.site.model.DocumentFormat;
import com.site.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "report",
		produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ReportRestController {

	private final ReportService service;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public void sendReport(@RequestParam String email,
	                       @RequestParam(name = "doc_format", required = false, defaultValue = "XLS") DocumentFormat format,
	                       @RequestParam(required = false) String filter) {
		service.sendReport(email, format, filter);
	}
}