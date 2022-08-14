package start.project.higia.utils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail(String email, String subject, String body) throws MessagingException {

		//SimpleMailMessage message = new SimpleMailMessage();

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setFrom("starthigiaproject@gmail.com");
		helper.setTo(email);
		helper.setText(body, true);
		helper.setSubject(subject);

		mailSender.send(message);

	}

}
