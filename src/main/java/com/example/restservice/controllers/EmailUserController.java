package com.example.restservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.services.EmailSenderService;


@RestController
public class EmailUserController {
/*
	@Autowired
	private EmailSenderService emailSenderService;

	//@EventListener(ApplicationReadyEvent.class)
	@PostMapping("/sendemail/{subject}/{message}")
	public void sendEmail(@PathVariable(value = "subject") String subject, @PathVariable(value = "message") String message) {
		
		emailSenderService.sendSimpleEmail("to@domain.com", message, subject);
		//emailSenderService.sendEmailWithAttachment("spring.email.to@gmail.com", "This is Email Body with Attachment...",
		//		"This email has attachment", "C:\\Users\\motop\\Downloads\\c.gif");

	}
*/
}
