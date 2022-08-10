package start.project.higia.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import start.project.higia.models.User;
import start.project.higia.services.UserService;

@Controller
public class LoginUserController {

	@Autowired
	UserService userService;

	@GetMapping("/user/login")
	public String login() {

		return "login/patient";
	}

	// User Login

	@PostMapping("/user/logon")
	public String userLogon(User user, HttpSession session, Model model) {

		user = userService.findByEmailAndPassword(user.getEmail(), user.getPassword());

		if (user != null) {

			session.setAttribute("logged", user);
			session.setAttribute("user", 1);

			return "redirect:/use";
		} else {
			model.addAttribute("message", "E-mail não cadastrado ou senha inválida.");
			model.addAttribute("style", "p-3 mb-2 bg-danger text-white");
			model.addAttribute("icon", "fa-solid fa-check");

			return "login/patient";
		}

	}

	@GetMapping("/use/exit")
	public String exit(HttpSession session) {
		session.invalidate();

		return "redirect:/cookies";
	}

}
