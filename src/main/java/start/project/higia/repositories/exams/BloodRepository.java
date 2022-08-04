package start.project.higia.repositories.exams;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import start.project.higia.models.exams.Blood;

@Component
public interface BloodRepository extends JpaRepository<Blood, Long>{

	List<Blood> findByUserId(Long id);
	
}
