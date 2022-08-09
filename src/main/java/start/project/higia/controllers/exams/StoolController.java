package start.project.higia.controllers.exams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import start.project.higia.models.exams.Stool;
import start.project.higia.services.UserService;
import start.project.higia.services.exams.StoolService;

@Controller
public class StoolController {
	
	@Autowired
	private StoolService service; 
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/stool/create")
	public String create(Stool stool) {

		return "";
	}
	
	@PostMapping("/stool/save")
	public String save(Stool stool) {
		service.create(stool);
		return "";
	}
	
	@GetMapping("/stool/index/{id}")
	public String indexById(@PathVariable Long id, Model model) {
		model.addAttribute("stools", service.index(id));
		return "tests/zap";
	}
	
	@GetMapping("/doc/list/stools")
	public String stoolList(Stool stool, Model model) {
		model.addAttribute("stools", service.indexAll(stool));
		System.out.println(service.indexAll(stool));
		return "";
	}
	

}
