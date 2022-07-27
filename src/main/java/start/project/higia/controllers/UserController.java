package start.project.higia.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String create(@Valid User user, Model model) {

		try {
			model.addAttribute("message", "Conta criada com sucesso.");
			model.addAttribute("style", "toast bg-success text-white align-items-center show");
			model.addAttribute("icon", "fa-solid fa-check");

			userService.create(user);
			emailSender.sendEmail(user.getEmail(), "Higia - Create Account", "Account created successfully");
			return "register/patient";
		} catch (DataIntegrityViolationException ex) {
			model.addAttribute("message", "Email ou CPF já cadastrado!");
			model.addAttribute("style", "toast bg-danger text-white align-items-center show");
			model.addAttribute("icon", "fa-solid fa-triangle-exclamation");

			return "register/patient";
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
