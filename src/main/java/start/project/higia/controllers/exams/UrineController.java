package start.project.higia.controllers.exams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import start.project.higia.models.exams.Urine;
import start.project.higia.services.exams.UrineService;

@Controller
public class UrineController {
	
	@Autowired
	private UrineService service;
	
	@GetMapping("/urine/create")
	public String create(Urine urine) {

		return "";
	}
	
	@PostMapping("/urine/save")
	public String save(Urine urine) {
		service.create(urine);
		return "";
	}
	
	@GetMapping("/urine/index/{id}")
	public String mostrar(@PathVariable Long id, Model model) {
		model.addAttribute("urines", service.index(id));
		return "tests/zap";
	}

}
