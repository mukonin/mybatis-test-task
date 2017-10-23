package com.site.report;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "report",
		produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ReportRestController {

	private final ReportService service;

	@GetMapping
	public ResponseEntity sendReport(@RequestParam String email,
	                                 @RequestParam(name = "doc_format", required = false) String docFormat,
	                                 @RequestParam(required = false) String filter) {
		return null;
	}
}