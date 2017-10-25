package com.site.service;

import com.site.model.DocumentFormat;
import com.site.model.Report;
import com.site.repository.ReportRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReportService {

	private final ReportRepository repository;

	public void sendReport(String email, DocumentFormat format, String filter) {
		List<Report> reports = repository.findAll();
	}
}