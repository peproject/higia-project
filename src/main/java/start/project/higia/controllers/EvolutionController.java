package start.project.higia.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import start.project.higia.models.Evolution;
import start.project.higia.services.EvolutionServices;

@Controller
public class EvolutionController {
	
    //Lendo classe de serviço da evolution 
	@Autowired
	private EvolutionServices services;
	
	@GetMapping("/Evolution")
	public String index(Evolution evolution, Model model) {
		model.addAttribute("evolution", this.services.index(evolution));
		return "index";
	}
	
	//rota para tela de cadastro
	@GetMapping("/evolution_registration")
	public String registration() {
		return "index";
	
	}
	//Rota para salvar a evolution no banco de dados
	@PostMapping("/evolution")
	public String create(Evolution evolution) {
		this.services.create(evolution);
		return "index";
	}
	
	//Rota para edição da evolution
	@GetMapping("/edit_evolution/{id}")
	public String editar_user(@PathVariable Long id, Model model) {
		Optional<Evolution> evolution = this.services.editById(id);
		model.addAttribute("evolution", evolution);
		return "";
	}

	//Rota para exclusão da evolution
	@GetMapping("/delete_evolution")
	public String excluir_user(Long id) {
		services.deleteById(id);
		return "redirect:/evolution";
	}
}

