package start.project.higia.controllers;

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
		return "index";
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
		return "";
	}
	
}
