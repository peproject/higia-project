package start.project.higia.controllers;

import java.util.Optional;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import start.project.higia.models.User;
import start.project.higia.services.UserService;
import start.project.higia.utils.EmailSenderService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private EmailSenderService emailSender;

	@GetMapping("/use")
	public String login() {
		return "/home/patient";
	}

	// Rota para tela de Cadastro de usuarios
	@GetMapping("/user/registration")
	public String registration() {
		return "/register/patient";
	}

	// Rota post para salvar os usuarios
	@PostMapping("/user")
	public String create(@Valid User user, RedirectAttributes redirect) throws MessagingException {

		try {
			redirect.addFlashAttribute("message", "Conta criada com sucesso.");
			redirect.addFlashAttribute("style", "p-3 mb-2 bg-success text-white rounded");
			redirect.addFlashAttribute("icon", "fa-solid fa-check");

      user.setPassword(userService.encryptPassword(user));

			userService.create(user);
			emailSender.sendEmail(user.getEmail(), "Higia - Create Account", "Account created successfully");

			return "redirect:/user/login";
		} catch (DataIntegrityViolationException ex) {

			redirect.addFlashAttribute("message", "Email ou CPF já cadastrado!");
			redirect.addFlashAttribute("style", "p-3 mb-2 bg-danger text-white rounded");
			redirect.addFlashAttribute("icon", "fa-solid fa-triangle-exclamation");

			return "redirect:/user/registration";
		}
	}

	// Rota para exibir todos os users
	@GetMapping("/use/index")
	public String index(User user, Model model) {
		model.addAttribute("users", this.userService.index(user));
		return "index2";
	}

	// Rota para edição de usuario
	@GetMapping("/use/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		Optional<User> usu = this.userService.editById(id);
		model.addAttribute("users", usu);
		return "edit/patient";
	}

	// Rota para exclusão do usuario
	@GetMapping("/use/delete")
	public String delete(@RequestParam Long id) {
		userService.deleteById(id);
		return "redirect:/user/login";
	}

}
