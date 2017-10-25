package com.site.service;

import com.site.model.DocumentFormat;
import com.site.model.MailDTO;
import com.site.model.Report;
import com.site.repository.ReportRepository;
import com.site.util.ExcelUtil;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReportService {

	private final ReportRepository repository;
	private final Environment environment;

	public void sendReport(String email, DocumentFormat format, String filter) {
		List<Report> reports = repository.findAll();
		Object[][] tableData = reports
				.stream()
				.map(ReportService::mapToFieldsArray).toArray(Object[][]::new);

		byte[] attachment = ExcelUtil.convert(tableData);

		String[] to = new String[1];
		to[0] = email;
		MailDTO mail = new MailDTO();
		mail.setFrom(environment.getProperty("email.from"));
		mail.setTo(to);
		mail.setSubject("Report");
		mail.setBody("Report");
		mail.setAttachmentName("report.xls");
		mail.setAttachment(attachment);
	}

	private static Object[] mapToFieldsArray(Report report) {
		Object[] row = new Object[7];
		row[0] = report.getCountryName();
		row[1] = report.getUserName();
		row[2] = report.getUrl();
		row[3] = report.getMethod();
		row[4] = report.getParams();
		row[5] = report.getRequestId();
		row[6] = report.getSessionId();
		return row;
	}
}