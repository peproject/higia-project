package start.project.higia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import start.project.higia.models.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long> {
}
