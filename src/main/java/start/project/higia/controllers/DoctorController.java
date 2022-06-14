package start.project.higia.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import start.project.higia.models.Doctor;
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
		return "index";
	}
	
	//Rota para salvar o doutor no banco de dados
	@PostMapping("/doctor")
	public String create(Doctor doctor) {
		this.services.create(doctor);
		return "index";
	}
	
	//Rota para edição de doutor
	@GetMapping("/edit_doctor/{id}")
	public String editar_user(@PathVariable Long id, Model model) {
		Optional<Doctor> doctor = this.services.editById(id);
		model.addAttribute("doctor", doctor);
		return "";
	}

	//Rota para exclusão do doutor
	@GetMapping("/delete_doctor")
	public String excluir_user(Long id) {
		services.deleteById(id);
		return "redirect:/doctor";
	}
}
