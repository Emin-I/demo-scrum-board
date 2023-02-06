package com.example.restservice.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import java.io.File;
import javax.mail.internet.MimeMessage;


@Service
public class EmailSenderService {

	@Autowired
	private JavaMailSender emailSender;

	public void sendSimpleEmail(String toEmail, String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom("spring.email.from@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);

		this.emailSender.send(message);

		System.out.println("Simple email sent.");
	}

	public void sendEmailWithAttachment(String toEmail, String body, String subject, String attachment)
			throws Exception {

		MimeMessage mimeMessage = emailSender.createMimeMessage();

		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

		mimeMessageHelper.setFrom("spring.email.from@gmail.com");
		mimeMessageHelper.setTo(toEmail);
		mimeMessageHelper.setText(body);
		mimeMessageHelper.setSubject(subject);

		FileSystemResource fileSystem = new FileSystemResource(new File(attachment));

		mimeMessageHelper.addAttachment(fileSystem.getFilename(), fileSystem);

		emailSender.send(mimeMessage);

		System.out.println("Email with attachment sent.");
	}

	// @EventListener(ApplicationReadyEvent.class)
	public void sendEmail(String email, String subject, String body) {

		this.sendSimpleEmail(email, subject, body);

	}

}