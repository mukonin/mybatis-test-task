package com.site.service;

import com.site.model.DocumentFormat;
import com.site.model.MailDTO;
import com.site.model.Report;
import com.site.repository.ReportRepository;
import com.site.util.ExcelUtil;
import com.site.util.WordUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
@Slf4j
public class ReportService {

	private final ReportRepository repository;
	private final MailService mailService;
	private final Environment environment;

	private static final String REPORT_SUBJECT_BODY = "Report";
	private static final Map<DocumentFormat, String> FILE_NAMES = new EnumMap<>(DocumentFormat.class);

	static {
		FILE_NAMES.put(DocumentFormat.XLS, "report.xls");
		FILE_NAMES.put(DocumentFormat.DOC, "report.doc");
	}

	public void sendReport(String email, DocumentFormat format, String filter) {
		List<Report> reports = repository.findAll();
		Object[][] tableData = reports
				.stream()
				.map(ReportService::mapToFieldsArray).toArray(Object[][]::new);

		byte[] attachment = getAttachment(tableData, format);

		MailDTO mail = buildMail(email, attachment, format);
		mailService.sendMail(mail);
	}

	private static byte[] getAttachment(Object[][] tableData, DocumentFormat format) {
		byte[] result;
		switch (format) {
			case DOC:
				result = WordUtil.convert(tableData);
				break;
			case XLS:
				result = ExcelUtil.convert(tableData);
				break;
			default:
				throw new IllegalArgumentException("Unknown data format " + format.name());
		}
		return result;
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

	private MailDTO buildMail(String email, byte[] attachment, DocumentFormat format) {
		String[] to = new String[1];
		to[0] = email;
		MailDTO mail = new MailDTO();
		mail.setFrom(environment.getProperty("mail.from"));
		mail.setTo(to);
		mail.setSubject(REPORT_SUBJECT_BODY);
		mail.setBody(REPORT_SUBJECT_BODY);
		mail.setAttachmentName(FILE_NAMES.get(format));
		mail.setAttachment(attachment);
		return mail;
	}
}