package start.project.higia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import start.project.higia.models.Evolution;
import start.project.higia.repositories.EvolutionRepository;

@Component
public class EvolutionService {

	@Autowired
	private EvolutionRepository repository;

	// Serviço para salvar a evolution no banco de dados
	public Evolution create(Evolution evolution) {
		return repository.save(evolution);
	}

	// Serviço para listar as evolutions
	public List<Evolution> index(Evolution evolution) {
		return repository.findAll();
	}

	// Serviço para editar a evolution
	public Optional<Evolution> editById(Long id) {
		return repository.findById(id);
	}

	// Serviço para deletar a evolution
	public String deleteById(Long id) {
		repository.deleteById(id);
		return "";
	}
}

