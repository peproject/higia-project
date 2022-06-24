package start.project.higia.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import start.project.higia.models.Doctor;
import start.project.higia.services.DoctorServices;

@Controller
public class LoginDoctorController {

	@Autowired
	DoctorServices services;

	@GetMapping("/doctor/login")
	public String login() {

		return "login/doctor";
	}

	@PostMapping("/doctor/logon")
	public String logon(Doctor doctor, HttpSession session, Model model) {

		doctor = services.findByEmailAndPassword(doctor.getEmail(), doctor.getPassword());

		if (doctor != null) {

			session.setAttribute("loggedDoctor", doctor);

			return "redirect:/";
		} else {
			model.addAttribute("message", "E-mail não cadastrado ou senha inválida.");
			model.addAttribute("style", "p-3 mb-2 bg-danger text-white");
			model.addAttribute("icon", "fa-solid fa-check");

			return "login/doctor";
		}

	}

	@GetMapping("/doc/exit")
	public String exit(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
