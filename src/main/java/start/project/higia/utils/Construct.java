package start.project.higia.utils;

import java.util.Locale;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import start.project.higia.models.Doctor;

@Component
public class Construct {

	public SimpleMailMessage constructResetTokenEmail(String contextPath, Locale locale, String token, Doctor doctor) {
		String url = contextPath + "/doctor/change?token=" + token;
		//String message = messages.getMessage("message.resetPassword", null, locale);
		return constructEmail(
			"Recuperar senha",
			"clique <a href=\"" + url + "\" targe=\"_blank\">aqui</a> para alterar sua senha!", doctor);
	}

	private SimpleMailMessage constructEmail(String subject, String body, Doctor doctor) {
		SimpleMailMessage email = new SimpleMailMessage();
		email.setSubject(subject);
		email.setText(body);
		email.setTo(doctor.getEmail());
		email.setFrom("Higia <starthigiaproject@gmail.com>");
		return email;
	}

}
