package start.project.higia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import start.project.higia.models.ImageExam;
import start.project.higia.services.ImageExamService;

import java.util.Optional;

@Controller
public class ImageExamController {

	@Autowired
	private ImageExamService imageExamService;

	@GetMapping("/imageExam")
	public String uploadPhoto() {
		return "imageExam";
	}

	@GetMapping("/imageExam/{id}")
	public String getById(@PathVariable Long id, Model model) {
		Optional<ImageExam> imageExamOptional = imageExamService.getById(id);
		model.addAttribute("imageExam", imageExamOptional);
		return "get/imageExam";
	}

	@GetMapping("/imageExam/delete/{id}")
	public String deleteImageExam(@PathVariable Long id) {
		imageExamService.deleteById(id);
		return "redirect:/user/login";
	}



}
