package start.project.higia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {

	@GetMapping("/registration")
	public String registration() {
		return "register/index";
	}
}
