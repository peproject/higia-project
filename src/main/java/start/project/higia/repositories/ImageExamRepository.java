package start.project.higia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import start.project.higia.models.ImageExam;

@Repository
public interface ImageExamRepository extends JpaRepository<ImageExam, Long> {

	List<ImageExam> findAllByUserId(Long id);
}
