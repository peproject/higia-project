package start.project.higia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExamController {

	@GetMapping("/exams")
	public String exams() {

		return "exams/index";
	}

}
