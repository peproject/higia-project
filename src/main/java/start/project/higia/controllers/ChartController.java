package start.project.higia.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import start.project.higia.models.Chart;
import start.project.higia.services.ChartServices;

@Controller
public class ChartController {

	@Autowired
	private ChartServices services;


	@GetMapping("/chart")
	public String index(Chart chart) {
		return "index";
	}

	@GetMapping("/chart/registration")
	public String registration(Chart chart) {
		return "register/chart";
	}

	@PostMapping("/chart")
	public String create(Chart chart) {
		this.services.create(chart);
		return "index";
	}

	//rota para edição de chart
	@GetMapping("/chart/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		Optional<Chart> chart = this.services.editById(id);
		model.addAttribute("chart", chart);
		return "edit/chart";
	}

	//rota para exclusão do chart
	@GetMapping("/chart/delete/{id}")
	public String delete(Long id) {
		services.deleteById(id);
		return "redirect:/chart";
	}
}
