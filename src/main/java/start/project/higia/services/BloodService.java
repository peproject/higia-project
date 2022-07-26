package start.project.higia.services;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import start.project.higia.models.exams.Blood;
import start.project.higia.repositories.BloodRepository;



@Component
public class BloodService {
	
	@Autowired
	private BloodRepository repository;
	
	public Blood create(Blood blood) {
		
		return repository.save(blood);
	}
	
	
	public Collection<Blood> mostrarExames(Long id){
		return repository.findByUserId(id);
	}

}
