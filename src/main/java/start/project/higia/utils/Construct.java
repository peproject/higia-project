package start.project.higia.utils;

import java.util.Locale;

import org.springframework.stereotype.Component;

import start.project.higia.models.Doctor;
import start.project.higia.models.User;

@Component
public class Construct {

	public String constructResetTokenEmail(String contextPath, Locale locale, String token, Doctor doctor) {
		String url = contextPath + token;
		return "Email de recuperação: " +
			"Clique <a href=\"" + url + "\" targe=\"_blank\">aqui</a> para alterar sua senha!";
	}

	public String ResetTokenEmail(String contextPath, Locale locale, String token, User user) {
		String url = contextPath + token;

		return "Email de recuperação: " +
			"Clique <a href=\"" + url + "\" targe=\"_blank\">aqui</a> para alterar sua senha!" + user.getEmail();
	}

}
