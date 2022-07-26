package start.project.higia.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import start.project.higia.models.exams.Blood;
import start.project.higia.services.BloodService;

@Controller
public class BloodController {
	
	@Autowired
	private BloodService service;
	
	@PostMapping("/createBlood")
	public String create(Blood blood) {
		service.create(blood);
		return "tests/teste";
	}
	
	@GetMapping("/bloods/{id}")
	public String mostrar(@PathVariable Long id, Model model) {
		model.addAttribute("blods", service.index(id));
		return "zap";
}

}
