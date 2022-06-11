package start.project.higia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import start.project.higia.models.Chart;
import start.project.higia.services.ChartServices;

@Controller
public class ChartController {

	@Autowired
	private ChartServices services;
	
	@GetMapping("/chart")
	public String index(Chart chart, Model model) {
		model.addAttribute("chart", this.services.index(chart));
		return "index";
	}
	
	@GetMapping("chart_registration")
	public String registration() {
		return "index";
	}
	
	@PostMapping("/chart")
	public String create(Chart chart) {
		this.services.create(chart);
		return "index";
	}
}
