package start.project.higia.repositories.exams;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import start.project.higia.models.exams.Stool;

@Component
public interface StoolRepository extends JpaRepository<Stool, Long>{
	
	List<Stool> findByUserId (Long id);

}
