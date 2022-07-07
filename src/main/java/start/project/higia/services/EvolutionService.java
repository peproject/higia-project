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
	private EvolutionRepository evolutionRepository;

	// Serviço para salvar a evolution no banco de dados
	public Evolution create(Evolution evolution) {
		return evolutionRepository.save(evolution);
	}

	// Serviço para listar as evolutions
	public List<Evolution> index(Evolution evolution) {
		return evolutionRepository.findAll();
	}

	// Serviço para editar a evolution
	public Optional<Evolution> editById(Long id) {
		return evolutionRepository.findById(id);
	}

	// Serviço para deletar a evolution
	public String deleteById(Long id) {
		evolutionRepository.deleteById(id);
		return "";
	}
}

