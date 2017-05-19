package com.webosoft.notification;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class NotificationUtil {
	public static void main(String args[]) {
		EmailDTO emailDto = new EmailDTO();
		emailDto.setBody("Test Body");
		emailDto.setSubject("Test Sub");
		List<String> to = new ArrayList<String>();
		to.add("miracleaggarwal@gmail.com");
		to.add("official.vipin.aggarwal@gmail.com");
		emailDto.setTo(to);
		sendEmail(emailDto);
	}

	public static void sendEmail(EmailDTO emailDto) {
		final String user = "info.marriazo@gmail.com";
		final String password = "admin@info";

		List<String> to = emailDto.getTo();
		Address[] toAddresses = new InternetAddress[to.size()];
		for (int i = 0; i < to.size(); i++) {
			try {
				String email = to.get(i);
				toAddresses[i] = new InternetAddress(email);
			} catch (AddressException e) {
				e.printStackTrace();
			}
		}

		List<String> cc = emailDto.getCc();
		Address[] ccAddresses =new InternetAddress[cc.size()];
		for (int i = 0; i < cc.size(); i++) {
			try {
				String email = cc.get(i);
				ccAddresses[i] = new InternetAddress(email);
			} catch (AddressException e) {
				e.printStackTrace();
			}
		}

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		// get Session
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		// Compose the message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipients(Message.RecipientType.TO, toAddresses);
			if (ccAddresses.length > 0) {
				message.addRecipients(Message.RecipientType.CC, ccAddresses);
			}
			message.setSubject(emailDto.getSubject());
			message.setText(emailDto.getBody());

			// send the message
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
