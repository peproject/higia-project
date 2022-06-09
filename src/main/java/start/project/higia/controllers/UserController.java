package start.project.higia.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String create(User user) {
		services.create(user);
		return "index";
	}
	
	//Rota para exibir todos os users
	@GetMapping("/index_users")
	public String index(User user, Model model) {
		model.addAttribute("users", this.services.index(user));
		return "index2";
	}
	
	//Rota para edição de usuario
	@GetMapping("/editar_user")
	public String editar_user(Long id, Model model) {
		Optional<User> usu = this.services.editById(id);
		model.addAttribute("users", usu);
		return "cadastraruserss";
	}

	//Rota para exclusão do usuario
	@GetMapping("/excluir_user")
	public String excluir_user(Long id) {
		services.deleteById(id);
		return "redirect:index_users";
	}
	
}
