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
import start.project.higia.services.UserServices;
import start.project.higia.utils.EmailSenderService;

@Controller
public class UserController {

	@Autowired
	private UserServices services;

	@Autowired
	private EmailSenderService emailSender;

	//Rota para tela de Cadastro de usuarios
	@GetMapping("/user/registration")
	public String registration() {
		return "/register/patient";
	}

	//Rota post para salvar os usuarios
	@PostMapping("/user")
	public String create(@Valid User user, Model model) {

		try {
			model.addAttribute("style", "p-3 mb-2 bg-success text-white");
			model.addAttribute("message", "Conta criada com sucesso!");
			model.addAttribute("icon", "fa-solid fa-triangle-exclamation");

			services.create(user);
			emailSender.sendEmail(user.getEmail(), "Higia - Create Account", "Account created successfully");
			return "register/patient";
		} catch(DataIntegrityViolationException ex) {
				model.addAttribute("message", "Não foi possivel criar conta! Email ou CPF já cadastrado.");
				model.addAttribute("style", "p-3 mb-2 bg-danger text-white");
				model.addAttribute("icon", "fa-solid fa-check");
				return "register/patient";
		}
	}

	//Rota para exibir todos os users
	@GetMapping("/user/index")
	public String index(User user, Model model) {
		model.addAttribute("users", this.services.index(user));
		return "index2";
	}

	//Rota para edição de usuario
	@GetMapping("/user/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		Optional<User> usu = this.services.editById(id);
		model.addAttribute("users", usu);
		return "edit/patient";
	}

	//Rota para exclusão do usuario
	@GetMapping("/user/delete")
	public String delete(@RequestParam Long id) {
		services.deleteById(id);
		return "redirect:/use/index";
	}

}
