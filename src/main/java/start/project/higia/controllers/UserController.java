package start.project.higia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import start.project.higia.models.User;
import start.project.higia.services.UserServices;

@Controller
public class UserController {

	@Autowired
	private UserServices services;
	
	@PostMapping("/user")
	public String create(User user) {
		services.create(user);
		return "index";
	}
	
}
