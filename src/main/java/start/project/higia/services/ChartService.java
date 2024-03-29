package start.project.higia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import start.project.higia.models.Chart;
import start.project.higia.repositories.ChartRepository;

import javax.transaction.Transactional;

@Component
public class ChartService {

	@Autowired
	private ChartRepository chartRepository;

	@Transactional
	public Chart create(Chart chart) {
		return chartRepository.save(chart);
	}

	public List<Chart> index(Chart chart) {
		return chartRepository.findAll();
	}

	public Optional<Chart> editById(Long id) {
		return chartRepository.findById(id);
	}

	@Transactional
	public String deleteById(Long id) {
		chartRepository.deleteById(id);
		return "";
	}

}
