package start.project.higia.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import start.project.higia.models.Doctor;
import start.project.higia.services.DoctorService;
import start.project.higia.utils.EmailSenderService;

@Controller
public class DoctorController {

	// Lendo classe de serviço do doutor
	@Autowired
	private DoctorService doctorService;

	@Autowired
	private EmailSenderService emailSender;

	@GetMapping("/doc")
	public String index(Doctor doctor, Model model) {
		model.addAttribute("doctor", this.doctorService.index(doctor));
		return "login/doctor";
	}

	// Rota para tela de cadastro
	@GetMapping("/doctor/registration")
	public String registration() {
		return "register/doctor";
	}

	// Rota para salvar o doutor no banco de dados
	@PostMapping("/doctor")
	public String create(@Valid Doctor doctor, Model model) {

		try {
			model.addAttribute("message", "Conta criada com sucesso.");
			model.addAttribute("style", "toast bg-success text-white align-items-center show");
			model.addAttribute("icon", "fa-solid fa-check");

			this.doctorService.create(doctor);
			emailSender.sendEmail(doctor.getEmail(), "Higia - Create Account", "Account created successfully");
			return "register/doctor";
		} catch (DataIntegrityViolationException ex) {
			model.addAttribute("message", "Email ou CRM já cadastrado.");
			model.addAttribute("style", "toast bg-danger text-white align-items-center show");
			model.addAttribute("icon", "fa-solid fa-triangle-exclamation");

			return "register/doctor";
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
}
