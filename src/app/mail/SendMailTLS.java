package app.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

public class SendMailTLS {

	static Logger log = Logger.getLogger(SendMailTLS.class.getName());

	public static void sendEmail(String subject, String body) {

		final String username = "noreply_school@mail.ru";
		final String password = "dc69866";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.mail.ru");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("noreply_school@mail.ru"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("nkorlova@mail.ru"));
			message.setSubject(subject);
			message.setText(body);

			Transport.send(message);

			log.info("email sent");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}