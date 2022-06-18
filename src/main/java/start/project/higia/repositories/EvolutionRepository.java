package start.project.higia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import start.project.higia.models.Evolution;

@Component
public interface EvolutionRepository extends JpaRepository<Evolution, Long> {

}