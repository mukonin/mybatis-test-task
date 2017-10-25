package com.site.service;

import com.site.model.MailDTO;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.internet.InternetAddress;

@Service
@AllArgsConstructor
public class MailService {

	private final JavaMailSender sender;

	public void sendMail(MailDTO mail) {
		byte[] attachment = mail.getAttachment();
		boolean hasAttachments = attachment != null;
		MimeMessagePreparator preparator = mimeMessage -> {
			MimeMessageHelper message = new MimeMessageHelper(mimeMessage, hasAttachments);
			message.setFrom(new InternetAddress(mail.getFrom()));
			message.setTo(mail.getTo());
			message.setSubject(mail.getSubject());
			message.setText(mail.getBody());
			if (hasAttachments) {
				message.addAttachment(mail.getAttachmentName(), new ByteArrayResource(attachment));
			}
		};
		sender.send(preparator);
	}
}