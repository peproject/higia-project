package start.project.higia.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import start.project.higia.models.DoctorPasswordTokens;
import start.project.higia.services.DoctorPasswordTokensServices;

@Controller
public class DoctorPasswordTokensController {

  	@Autowired
  	DoctorPasswordTokensServices services;
	
	@PostMapping("/create/token")
	public String create(@Valid DoctorPasswordTokens doctor) {
  		this.services.create(doctor);
		return "index";
	}
}
