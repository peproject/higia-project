package start.project.higia.controllers.exams;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import start.project.higia.models.User;
import start.project.higia.models.exams.Stool;
import start.project.higia.services.UserService;
import start.project.higia.services.exams.StoolService;

@Controller
public class StoolController {

	@Autowired
	private StoolService service;

	@Autowired
	private UserService userService;

	@GetMapping("/doc/list/stools")
	public String doctorStoolList(Stool stool, Model model) {

		model.addAttribute("stools", service.indexAll(stool));

		return "exams/stool";

	}

	@GetMapping("/use/list/stools")
	public String patientStoolList(Stool stool, Model model, HttpSession session) {
		User user = (User) session.getAttribute("logged");

		model.addAttribute("stools", service.findAllByUserId(user.getId()));

		return "user_exams/stool";

	}

	@PostMapping("/stool/save")
	public String save(@Valid Stool stool, String cpf, RedirectAttributes redirect) {

		try {
			User user = userService.findByCpf(cpf);

			System.out.println(cpf);
			stool.setUser(user);
			service.create(stool);

			redirect.addFlashAttribute("message", "Exame salvo");
			redirect.addFlashAttribute("style", "p-3 mb-2 bg-success text-white rounded");
			redirect.addFlashAttribute("icon", "fa-solid fa-check");

			return "redirect:/doc/list/stools";
		} catch(NullPointerException err) {

				redirect.addFlashAttribute("message", "Não existe um paciente com esse CPF");
				redirect.addFlashAttribute("style", "p-3 mb-2 bg-danger text-white rounded");
				redirect.addFlashAttribute("icon", "fa-solid fa-triangle-exclamation");

				return "redirect:/doc/list/stools";
		}
	}

}
