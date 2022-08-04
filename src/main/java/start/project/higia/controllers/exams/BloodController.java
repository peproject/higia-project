package start.project.higia.controllers.exams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import start.project.higia.models.exams.Blood;
import start.project.higia.services.exams.BloodService;

@Controller
public class BloodController {

	@Autowired
	private BloodService service;

	@GetMapping("/blood/create")
	public String create() {

		return "";
	}

	@PostMapping("/blood/save")
	public String save(Blood blood) {
		service.create(blood);
		return "";
	}

	@GetMapping("/blood/index/{id}")
	public String mostrar(@PathVariable Long id, Model model) {
		model.addAttribute("blods", service.index(id));
		return "tests/zap";
	}

}
