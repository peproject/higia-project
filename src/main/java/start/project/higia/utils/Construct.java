package start.project.higia.utils;

import java.util.Locale;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import start.project.higia.models.Doctor;
import start.project.higia.models.User;

@Component
public class Construct {

	public SimpleMailMessage constructResetTokenEmail(String contextPath, Locale locale, String token, Doctor doctor) {
		String url = contextPath + "/doctor/change?token=" + token;
		return constructEmail(
			"Recuperar senha",
			"clique <a href=\"" + url + "\" targe=\"_blank\">aqui</a> para alterar sua senha!", doctor.getEmail());
	}

	public SimpleMailMessage ResetTokenEmail(String contextPath, Locale locale, String token, User user) {
		String url = contextPath + "/doctor/change?token=" + user;
		return constructEmail(
			"Recuperar senha",
			"clique <a href=\"" + url + "\" targe=\"_blank\">aqui</a> para alterar sua senha!", user.getEmail());
	}
	
	private SimpleMailMessage constructEmail(String subject, String body, String email) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setSubject(subject);
		mail.setText(body);
		mail.setTo(email);
		mail.setFrom("Higia <starthigiaproject@gmail.com>");
		return mail;
	}
	
	

}
