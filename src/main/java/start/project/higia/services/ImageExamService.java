package start.project.higia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import start.project.higia.models.ImageExam;
import start.project.higia.repositories.ImageExamRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ImageExamService {

	@Autowired
	private ImageExamRepository imageExamRepository;

	@Transactional
	public ImageExam create(ImageExam imageExam) {
		return imageExamRepository.save(imageExam);
	}

	public List<ImageExam> findAllImageExams() {
		return imageExamRepository.findAll();
	}

	public Optional<ImageExam> getById(Long id) {
		return imageExamRepository.findById(id);
	}

	@Transactional
	public String deleteById(Long id) {
		imageExamRepository.deleteById(id);
		return "";
	}


}
