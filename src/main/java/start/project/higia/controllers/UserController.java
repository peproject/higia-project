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

import start.project.higia.models.User;
import start.project.higia.services.UserServices;

@Controller
public class UserController {

	@Autowired
	private UserServices services;

	//Rota para tela de Cadastro de usuarios
	@GetMapping("/user_registration")
	public String registration() {
		return "/register/patient";
	}

	//Rota post para salvar os usuarios
	@PostMapping("/save_user")
	public String create(@Valid User user, Model model) {

		try {
			model.addAttribute("style", "p-3 mb-2 bg-success text-white");
			model.addAttribute("message", "Conta criada com sucesso!");
			model.addAttribute("icon", "fa-solid fa-triangle-exclamation");

			services.create(user);
			return "register/patient";
		} catch(DataIntegrityViolationException ex) {
				model.addAttribute("message", "Não foi possivel criar conta! Email ou CPF já cadastrado.");
				model.addAttribute("style", "p-3 mb-2 bg-danger text-white");
				model.addAttribute("icon", "fa-solid fa-check");
				return "register/patient";
		}
	}

	//Rota para exibir todos os users
	@GetMapping("/index_users")
	public String index(User user, Model model) {
		model.addAttribute("users", this.services.index(user));
		return "index2";
	}

	//Rota para edição de usuario
	@GetMapping("/edit_user/{id}")
	public String editar_user(@PathVariable Long id, Model model) {
		Optional<User> usu = this.services.editById(id);
		model.addAttribute("users", usu);
		return "edit/patient";
	}

	//Rota para exclusão do usuario
	@GetMapping("/excluir_user/{id}")
	public String excluir_user(@PathVariable Long id) {
		services.deleteById(id);
		return "redirect:index_users";
	}

}
