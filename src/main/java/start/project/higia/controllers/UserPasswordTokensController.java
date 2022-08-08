package start.project.higia.controllers;

import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import start.project.higia.models.DoctorPasswordTokens;
import start.project.higia.models.User;
import start.project.higia.security.IUserSecurity;
import start.project.higia.services.UserPasswordTokensServices;
import start.project.higia.services.UserService;
import start.project.higia.utils.Construct;
import start.project.higia.utils.PasswordDto;

@Controller
public class UserPasswordTokensController {

	@Autowired
	UserPasswordTokensServices userPasswordTokensServicesservices;

	@Autowired
	UserService userService;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private IUserSecurity securityService;

	@Autowired
	private Construct construct;

	@PostMapping("/user/restore")
	public String create(HttpServletRequest request, @RequestParam("email") String email, DoctorPasswordTokens doc,
			RedirectAttributes redirect) {
		User user = userService.findByEmail(email);
		if (user == null) {

			redirect.addFlashAttribute("message", "E-mail não cadastrado.");
			redirect.addFlashAttribute("style", "p-3 mb-2 bg-danger text-white rounded");
			redirect.addFlashAttribute("icon", "fa-solid fa-check");

			return "redirect:/user/login";
		}
		String token = UUID.randomUUID().toString();
		userPasswordTokensServicesservices.create(user, token);
		mailSender.send(this.construct.ResetTokenEmail("localhost:8080", request.getLocale(), token, user));
		redirect.addFlashAttribute("message", "Por favor, verifique seu e-mail para uma mensagem com seu código!");
		redirect.addFlashAttribute("style", "p-3 mb-2 bg-primary text-white rounded");
		redirect.addFlashAttribute("icon", "fa-solid fa-circle-info");

		return "redirect:/user/login";
	}

	@GetMapping("/user/change")
	public String showChangePasswordPage(Locale locale, Model model, @RequestParam("token") String token,
			RedirectAttributes redirect) {
		String result = securityService.validatePasswordResetToken(token);
		if (result != null) {
			redirect.addFlashAttribute("message", "A token esta expirada");
			redirect.addFlashAttribute("style", "p-3 mb-2 bg-primary text-white rounded");
			redirect.addFlashAttribute("icon", "fa-solid fa-circle-info");
			return "redirect:/user/login";
		} else {
			model.addAttribute("token", token);
			return "forget/user";
		}
	}


}
