package start.project.higia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import start.project.higia.models.Exam;
import start.project.higia.services.ExamService;

@Controller
public class ExamController {

	@Autowired
	private ExamService examService;

	@PostMapping("/create/exam")
	public String create(Exam exam) {
		examService.create(exam);
		return "";
	}

	@GetMapping("/exam/{id}")
	public String getExamsById(@PathVariable Long id, Model model) {
		model.addAttribute("exams", examService.getById(id));
		return "";
	}

}
