package start.project.higia.services.exams;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import start.project.higia.models.exams.Stool;
import start.project.higia.repositories.exams.StoolRepository;

@Component
public class StoolService {

	@Autowired
	private StoolRepository repository;

	public Stool create(Stool stool) {

		return repository.save(stool);
	}

	public List<Stool> index(Long id) {
		return repository.findByUserId(id);
	}

}
