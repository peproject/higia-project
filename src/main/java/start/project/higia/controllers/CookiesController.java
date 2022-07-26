package start.project.higia.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CookiesController {

	@PostMapping("/cookies")
	public String acceptCookies(HttpSession session) {

		session.setAttribute("cookies", 1);

		return "redirect:/";
	}

	@PostMapping("/not-accept")
	public String notAcceptCookies(HttpSession session) {
		return "redirect:/";
	}
}
