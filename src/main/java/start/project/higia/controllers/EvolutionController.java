package start.project.higia.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import start.project.higia.models.Evolution;
import start.project.higia.services.EvolutionService;

@Controller
public class EvolutionController {

    //Lendo classe de serviço da evolution
	@Autowired
	private EvolutionService evolutionService;

	@GetMapping("/Evolution")
	public String index(Evolution evolution, Model model) {
		model.addAttribute("evolution", this.evolutionService.index(evolution));
		return "index";
	}

	//rota para tela de cadastro
	@GetMapping("/evolution/registration")
	public String registration() {
		return "index";

	}
	//Rota para salvar a evolution no banco de dados
	@PostMapping("/evolution")
	public String create(Evolution evolution) {
		this.evolutionService.create(evolution);
		return "index";
	}

	//Rota para edição da evolution
	@GetMapping("/edit/evolution/{id}")
	public String edit(@PathVariable Long id, Model model) {
		Optional<Evolution> evolution = this.evolutionService.editById(id);
		model.addAttribute("evolution", evolution);
		return "";
	}

	//Rota para exclusão da evolution
	@GetMapping("/evolution/delete/{id}")
	public String delete(@PathVariable Long id) {
		evolutionService.deleteById(id);
		return "redirect:/evolution";
	}
}

