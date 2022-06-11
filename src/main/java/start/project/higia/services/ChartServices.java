package start.project.higia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import start.project.higia.models.Chart;
import start.project.higia.repositories.ChartRepository;

@Component
public class ChartServices {
	
	@Autowired
	private ChartRepository repository;
	
	public Chart create(Chart chart) {
		return repository.save(chart);
	}
	
	public List<Chart> index(Chart chart) {
		return repository.findAll();
	}

}
