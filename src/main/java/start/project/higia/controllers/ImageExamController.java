package start.project.higia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import start.project.higia.models.ImageExam;
import start.project.higia.models.User;
import start.project.higia.services.ImageExamService;
import start.project.higia.services.S3Service;
import start.project.higia.services.UserService;

import javax.validation.Valid;

@Controller
public class ImageExamController {

	@Autowired
	private ImageExamService service;

	@Autowired
	private S3Service s3;

	@Autowired
	private UserService userService;

	@GetMapping("/doc/list/images")
	public String imageList(Model model) {
		model.addAttribute("images", service.findAllImageExams());

		return "exams/image";
	}

	@PostMapping("/image/save")
	public String save(@Valid ImageExam image, String cpf, @RequestParam(value = "file") MultipartFile file,
		RedirectAttributes redirect) {

		try {
			User user = userService.findByCpf(cpf);


			image.setUser(user);
			image.setName(s3.uploadFile(file));
			service.create(image);

			redirect.addFlashAttribute("message", "Exame salvo");
			redirect.addFlashAttribute("style", "p-3 mb-2 bg-success text-white rounded");
			redirect.addFlashAttribute("icon", "fa-solid fa-check");

			return "redirect:/test";
		} catch(NegativeArraySizeException err) {

				redirect.addFlashAttribute("message", "Não existe um paciente com esse CPF");
				redirect.addFlashAttribute("style", "p-3 mb-2 bg-danger text-white rounded");
				redirect.addFlashAttribute("icon", "fa-solid fa-triangle-exclamation");

				return "redirect:/test";
		}
	}

}
