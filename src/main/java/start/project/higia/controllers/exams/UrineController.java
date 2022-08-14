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
import start.project.higia.models.exams.Urine;
import start.project.higia.services.UserService;
import start.project.higia.services.exams.UrineService;

@Controller
public class UrineController {

	@Autowired
	private UrineService service;

	@Autowired
	private UserService userService;

	@GetMapping("/doc/list/urines")
	public String doctorUrineList(Urine urine, Model model) {

		model.addAttribute("urine", service.indexAll(urine));

		return "exams/urine";

	}

	@GetMapping("/use/list/urines")
	public String patientUrineList(Urine urine, Model model, HttpSession session) {
		User user = (User) session.getAttribute("logged");

		model.addAttribute("urine", service.findAllByUserId(user.getId()));
		return "user_exams/urine";

	}

	@PostMapping("/urine/save")
	public String save(@Valid Urine urine, String cpf, RedirectAttributes redirect) {

		try {
			User user = userService.findByCpf(cpf);

			System.out.println(cpf);
			urine.setUser(user);
			service.create(urine);

			redirect.addFlashAttribute("message", "Exame salvo");
			redirect.addFlashAttribute("style", "p-3 mb-2 bg-success text-white rounded");
			redirect.addFlashAttribute("icon", "fa-solid fa-check");

			return "redirect:/doc/list/urines";
		} catch(NullPointerException err) {

				redirect.addFlashAttribute("message", "Não existe um paciente com esse CPF");
				redirect.addFlashAttribute("style", "p-3 mb-2 bg-danger text-white rounded");
				redirect.addFlashAttribute("icon", "fa-solid fa-triangle-exclamation");

				return "redirect:/doc/list/urines";
		}
	}
}
