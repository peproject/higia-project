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

import start.project.higia.models.Doctor;
import start.project.higia.models.DoctorPasswordTokens;
import start.project.higia.security.ISecurityService;
import start.project.higia.services.DoctorPasswordTokensServices;
import start.project.higia.services.DoctorService;
import start.project.higia.utils.Construct;
import start.project.higia.utils.PasswordDto;

@Controller
public class DoctorPasswordTokensController {

	@Autowired
	DoctorPasswordTokensServices doctorPasswordTokensServicesservices;

	@Autowired
	DoctorService doctorService;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private ISecurityService securityService;

	@Autowired
	private Construct construct;

	@PostMapping("/doctor/restore")
	public String create(HttpServletRequest request, @RequestParam("email") String email,
			DoctorPasswordTokens doc, RedirectAttributes redirect) {
		Doctor doctor = doctorService.findByEmail(email);
		if (doctor == null) {

			redirect.addFlashAttribute("message", "E-mail não cadastrado.");
			redirect.addFlashAttribute("style", "p-3 mb-2 bg-danger text-white rounded");
			redirect.addFlashAttribute("icon", "fa-solid fa-check");

			return "redirect:/doctor/login";
		}
		String token = UUID.randomUUID().toString();
		doctorPasswordTokensServicesservices.create(doctor, token);
		mailSender.send(this.construct.constructResetTokenEmail("localhost:8080/doctor/change?token=", request.getLocale(), token, doctor));

		redirect.addFlashAttribute("message", "Por favor, verifique seu e-mail para uma mensagem com seu código!");
		redirect.addFlashAttribute("style", "p-3 mb-2 bg-primary text-white rounded");
		redirect.addFlashAttribute("icon", "fa-solid fa-circle-info");

		return "redirect:/doctor/login";
	}

	@GetMapping("/doctor/change")
	public String showChangePasswordPage(Locale locale, Model model, @RequestParam("token") String token, RedirectAttributes redirect) {
		String result = securityService.validatePasswordResetToken(token);

		if (result != null) {
			redirect.addFlashAttribute("message", "A token esta expirada");
		    redirect.addFlashAttribute("style", "p-3 mb-2 bg-primary text-white rounded");
		    redirect.addFlashAttribute("icon", "fa-solid fa-circle-info");

				return "redirect:/doctor/login";
		} else {

			model.addAttribute("token", token);

			return "forget/doctor";
		}
	}

	@PostMapping("/doctor/recover")
	public String savePassword(final Locale locale, @Valid PasswordDto passwordDto,
		RedirectAttributes redirect) {

		String result = securityService.validatePasswordResetToken(passwordDto.getToken());

		if (result != null) {

			redirect.addFlashAttribute("message", "Token inválido!");
			redirect.addFlashAttribute("style", "p-3 mb-2 bg-danger text-white rounded");
			redirect.addFlashAttribute("icon", "fa-solid fa-check");

			return "redirect:/doctor/login";
		}

		Optional<Doctor> doctor = doctorPasswordTokensServicesservices
				.getDoctorByPasswordResetToken(passwordDto.getToken());
		if (doctor.isPresent()) {
			doctorPasswordTokensServicesservices.changePassword(doctor.get(), passwordDto.getNewPassword());

			redirect.addFlashAttribute("message", "Senha alterada com sucesso!");
			redirect.addFlashAttribute("style", "p-3 mb-2 bg-success text-white rounded");
			redirect.addFlashAttribute("icon", "fa-solid fa-circle-info");

			return "redirect:/doctor/login";
		} else {
			redirect.addFlashAttribute("message", "Não foi possivel mudar a senha!");
			redirect.addFlashAttribute("style", "p-3 mb-2 bg-danger text-white rounded");
			redirect.addFlashAttribute("icon", "fa-solid fa-check");

			return "redirect:/doctor/login";
		}
	}

}
