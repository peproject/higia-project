package start.project.higia.repositories.exams;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import start.project.higia.models.exams.Urine;

@Component
public interface UrineRepository extends JpaRepository<Urine, Long> {

	List<Urine> findByUserId(Long id);

	List<Urine> findAllByUserId(Long id);

}
