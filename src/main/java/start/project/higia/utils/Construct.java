package start.project.higia.utils;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import start.project.higia.models.Doctor;

@Component
public class Construct {

	@Autowired
    private MessageSource messages;
	
	public SimpleMailMessage constructResetTokenEmail(String contextPath, Locale locale, String token, Doctor doctor) {
		String url = contextPath + "/user/changePassword?token=" + token;
		String message = messages.getMessage("message.resetPassword", null, locale);
		return constructEmail("Reset Password", message + " \r\n" + url, doctor);
	}

	
	
}
