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

	@GetMapping("/user/login")
	public String login() {

		return "login/patient";
	}

	//User Login

	@PostMapping("/user/logon")
	public String userLogon(User user, HttpSession session) {

		user = services.findByEmailAndPassword(user.getEmail(), user.getPassword());

		if (user != null) {

			session.setAttribute("loggedUser", user);

			return "redirect:/";
		} else
		{
			return "redirect:/user_login";
		}
		

	}
	
	@GetMapping("/user/exit")
	public String exit(HttpSession session) {
		session.invalidate();
		return "redirect:/user_login";
	}

}
