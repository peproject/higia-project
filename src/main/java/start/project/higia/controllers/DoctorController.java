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
import start.project.higia.models.Roles;
import start.project.higia.services.DoctorServices;

@Controller
public class DoctorController {

    //Lendo classe de serviço do doutor
	@Autowired
	private DoctorServices services;

	@GetMapping("/doctor")
	public String index(Doctor doctor, Model model) {
		model.addAttribute("doctor", this.services.index(doctor));
		return "index";
	}

	//Rota para tela de cadastro
	@GetMapping("/doctor_registration")
	public String registration() {
		return "register/doctor";
	}

	//Rota para salvar o doutor no banco de dados
	@PostMapping("/doctor")
	public String create(@Valid Doctor doctor, Model model) {

		try {
			model.addAttribute("style", "p-3 mb-2 bg-success text-white");
			model.addAttribute("message", "Conta criada com sucesso!");
			model.addAttribute("icon", "fa-solid fa-triangle-exclamation");

			doctor.setRole(Roles.DOCTOR);
			this.services.create(doctor);

			return "register/doctor";
		} catch(DataIntegrityViolationException ex) {
				model.addAttribute("message", "Não foi possivel criar conta! Email ou CRM já cadastrado.");
				model.addAttribute("style", "p-3 mb-2 bg-danger text-white");
				model.addAttribute("icon", "fa-solid fa-check");

				return "register/doctor";
		}
	}

	//Rota para edição de doutor
	@GetMapping("/edit_doctor/{id}")
	public String editar_user(@PathVariable Long id, Model model) {
		Optional<Doctor> doctor = this.services.editById(id);
		model.addAttribute("doctor", doctor);
		return "edit/doctor";
	}

	//Rota para exclusão do doutor
	@GetMapping("/delete_doctor/{id}")
	public String excluir_user(@PathVariable Long id) {
		services.deleteById(id);
		return "redirect:/doctor";
	}
}
