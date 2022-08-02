package start.project.higia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import start.project.higia.models.Exam;
import start.project.higia.models.exams.Blood;

import java.util.List;

public interface ExamRepository extends JpaRepository<Exam, Long> {
	List<Exam> findByUserId(Long id);
}
