package start.project.higia.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import start.project.higia.models.User;
import start.project.higia.services.UserServices;

@Controller
public class LoginUserController {

	@Autowired
	UserServices services;

	@GetMapping("/user_login")
	public String userLogin() {

		return "/tests/index";
	}

	//User Login

	@PostMapping("/logon_user")
	public String userLogon(User user, HttpSession session) {

		user = services.findByEmailAndPassword(user.getEmail(), user.getPassword());

		if (user != null) {

			session.setAttribute("loggedUser", user);

			return "redirect:/user_registration";
		} else
		{
			return "redirect:/user_login";
		}

	}

}
