package start.project.higia.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import start.project.higia.models.Doctor;
import start.project.higia.models.DoctorPasswordTokens;
import start.project.higia.services.DoctorPasswordTokensServices;
import start.project.higia.services.DoctorService;
import start.project.higia.utils.EmailSenderService;

@Controller
public class DoctorPasswordTokensController {

  	@Autowired
  	DoctorPasswordTokensServices doctorPasswordTokensServicesservices;
	
  	@Autowired
  	DoctorService doctorService;
  	
	@Autowired
	private EmailSenderService emailSender;
  	
	@PostMapping("/create/token")
	public String create(@Valid DoctorPasswordTokens doctor, Doctor doc, Model model) {
		doc = doctorService.findByEmail(doc.getEmail());
		
		if (doc != null) {
			this.doctorPasswordTokensServicesservices.create(doctor);
			emailSender.sendEmail(doc.getEmail(), "Higia Token", "new token" + doctor.getTokens());
            return "index";
		} else {
			model.addAttribute("message", "E-mail não cadastrado.");
			return "index";
		}		
	}
}
