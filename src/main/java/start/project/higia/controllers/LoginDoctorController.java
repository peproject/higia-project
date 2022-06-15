package start.project.higia.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import start.project.higia.models.Doctor;
import start.project.higia.services.DoctorServices;

@Controller
public class LoginDoctorController {

	@Autowired
	DoctorServices services;

	@GetMapping("/doctor_login")
	public String doctorLogin() {

		return "/tests/index";
	}

	@PostMapping("/logon_doctor")
	public String doctorLogon(Doctor doctor, HttpSession session) {

		doctor = services.findByEmailAndPassword(doctor.getEmail(), doctor.getPassword());

		if (doctor != null) {

			session.setAttribute("loggedDoctor", doctor);

			return "redirect:/user_registration";
		} else {
			return "redirect:/doctor_login";
		}

	}

}
