package start.project.higia.controllers;

import java.util.Optional;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import start.project.higia.models.Doctor;
import start.project.higia.models.Evolution;
import start.project.higia.models.User;
import start.project.higia.services.DoctorService;
import start.project.higia.services.EvolutionService;
import start.project.higia.services.UserService;
import start.project.higia.utils.EmailSenderService;

@Controller
public class DoctorController {

	// Lendo classe de serviço do doutor
	@Autowired
	private DoctorService doctorService;

	@Autowired
	private EmailSenderService emailSender;

	@Autowired
	private UserService userService;

	@Autowired
	private EvolutionService evoService;


	@GetMapping("/doc")
	public String index(Doctor doctor, Model model) {
		model.addAttribute("doctor", this.doctorService.index(doctor));
		return "home/doctor";
	}

	// Rota para tela de cadastro
	@GetMapping("/doctor/registration")
	public String registration() {
		return "register/doctor";
	}

	// Rota para salvar o doutor no banco de dados
	@PostMapping("/doctor")
	public String create(@Valid Doctor doctor, RedirectAttributes redirect) throws MessagingException {

		try {
			redirect.addFlashAttribute("message", "Conta criada com sucesso.");
			redirect.addFlashAttribute("style", "p-3 mb-2 bg-success text-white rounded");
			redirect.addFlashAttribute("icon", "fa-solid fa-check");

			doctor.setPassword(doctorService.encryptPassword(doctor));

			this.doctorService.create(doctor);
			emailSender.sendEmail(doctor.getEmail(), "Higia - Criação de Conta", "Conta criada com sucesso !!!");

			return "redirect:/doctor/login";
		} catch (DataIntegrityViolationException ex) {

			redirect.addFlashAttribute("message", "Email ou CRM já cadastrado.");
			redirect.addFlashAttribute("style", "p-3 mb-2 bg-danger text-white rounded");
			redirect.addFlashAttribute("icon", "fa-solid fa-triangle-exclamation");

			return "redirect:/doctor/registration";
		}
	}

	// Rota para edição de doutor
	@GetMapping("/doc/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		Optional<Doctor> doctor = this.doctorService.editById(id);
		model.addAttribute("doctor", doctor);
		return "edit/doctor";
	}

	// Rota para exclusão do doutor
	@GetMapping("/doc/delete/{id}")
	public String delete(@PathVariable Long id) {
		doctorService.deleteById(id);
		return "redirect:/doctor";
	}

	@GetMapping("/doc/list/patients")
	public String patientList(User user, Model model) {
		model.addAttribute("patients", userService.index(user));
		return "list/patient";
	}

	@GetMapping("/doc/list/evolutions")
	public String evolutionList(Evolution evolution, Model model) {
		model.addAttribute("evolutions", evoService.index(evolution));
		return "list/evolution";
	}


}
