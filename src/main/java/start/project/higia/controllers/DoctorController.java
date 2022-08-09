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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import start.project.higia.models.Doctor;
import start.project.higia.models.Evolution;
import start.project.higia.models.User;
import start.project.higia.models.exams.Blood;
import start.project.higia.models.exams.Stool;
import start.project.higia.models.exams.Urine;
import start.project.higia.services.DoctorService;
import start.project.higia.services.EvolutionService;
import start.project.higia.services.UserService;
import start.project.higia.services.exams.BloodService;
import start.project.higia.services.exams.StoolService;
import start.project.higia.services.exams.UrineService;
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

	@Autowired
	private BloodService bloodservice;

	@Autowired
	private StoolService stoolservice;

	@Autowired
	private UrineService urineservice;

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
	public String create(@Valid Doctor doctor, RedirectAttributes redirect) {

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

	@GetMapping("/doc/list/bloods")
	public String bloodList(Blood blood, Model model) {
		model.addAttribute("bloods", bloodservice.indexAll(blood));
		System.out.println(bloodservice.indexAll(blood));
		return "";
	}

	@GetMapping("/doc/list/stools")
	public String stoolList(Stool stool, Model model) {
		model.addAttribute("stools", stoolservice.indexAll(stool));
		System.out.println(stoolservice.indexAll(stool));
		return "";
	}


	@GetMapping("/doc/list/urines")
	public String urineList(Urine urine, Model model) {
		model.addAttribute("urines", urineservice.indexAll(urine));
		System.out.println(urineservice.indexAll(urine));
		return "tests/zap";
	}

}
