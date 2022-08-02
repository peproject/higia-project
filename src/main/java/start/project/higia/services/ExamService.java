package start.project.higia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import start.project.higia.models.Exam;
import start.project.higia.repositories.ExamRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExamService {

	@Autowired
	private ExamRepository examRepository;

	public Exam create(Exam exam) {
		return examRepository.save(exam);
	}

	public List<Exam> findAllExams(Exam exam) {
		return examRepository.findAll();
	}

	public List<Exam> getById(Long id) {
		return examRepository.findByUserId(id);
	}

	public String deleteById(Long id) {
		examRepository.deleteById(id);
		return "";
	}
}
