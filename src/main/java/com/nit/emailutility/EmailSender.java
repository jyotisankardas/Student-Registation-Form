package com.nit.emailutility;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {
	@Autowired
	private JavaMailSender sender;

	/**
	 * This method is used for Create Mime type mail
	 * 
	 * @param to
	 * @param sub
	 * @param text
	 * @throws MessagingException
	 * @throws IOException
	 */
	public void sendEmailWithAttachment(String to, String sub, String text) throws MessagingException, IOException {

		MimeMessage msg = sender.createMimeMessage();

		// true = multipart message
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);

		helper.setTo(to);

		helper.setSubject(sub);

		// default = text/plain
		// helper.setText("Check attachment for image!");

		// true = text/html
		helper.setText(text, true);

		sender.send(msg);

	}

}
