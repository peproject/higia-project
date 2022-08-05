package start.project.higia.services.exams;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import start.project.higia.models.exams.Urine;
import start.project.higia.repositories.exams.UrineRepository;

@Component
public class UrineService {
	
	@Autowired
	private UrineRepository repository;
	
	public Urine create(Urine urine) {
		
		return repository.save(urine);
	}
	
	public List <Urine> index(Long id) {
		return repository.findByUserId(id);
	}
	
	public List<Urine> indexAll(Urine urine) {
		return repository.findAll();
	}

}
