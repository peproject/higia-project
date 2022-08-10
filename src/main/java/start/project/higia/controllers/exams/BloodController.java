package start.project.higia.controllers.exams;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import start.project.higia.models.User;
import start.project.higia.models.exams.Blood;
import start.project.higia.services.UserService;
import start.project.higia.services.exams.BloodService;

@Controller
public class BloodController {

	@Autowired
	private BloodService service;

	@Autowired
	private UserService userService;

	@GetMapping("/doc/list/bloods")
	public String bloodList(Blood blood, Model model) {
		model.addAttribute("bloods", service.indexAll(blood));

		return "exams/blood";
	}

	@PostMapping("/blood/save")
	public String save(@Valid Blood blood, String cpf, RedirectAttributes redirect) {

		try {
			User user = userService.findByCpf(cpf);

			System.out.println(cpf);
			blood.setUser(user);
			service.create(blood);

			redirect.addFlashAttribute("message", "Exame salvo");
			redirect.addFlashAttribute("style", "p-3 mb-2 bg-success text-white rounded");
			redirect.addFlashAttribute("icon", "fa-solid fa-check");

			return "redirect:/doc/list/bloods";
		} catch(NullPointerException err) {

				redirect.addFlashAttribute("message", "Não existe um paciente com esse CPF");
				redirect.addFlashAttribute("style", "p-3 mb-2 bg-danger text-white rounded");
				redirect.addFlashAttribute("icon", "fa-solid fa-triangle-exclamation");

				return "redirect:/doc/list/bloods";
		}
	}

}
