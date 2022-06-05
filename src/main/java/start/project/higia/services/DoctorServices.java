package start.project.higia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import start.project.higia.models.Doctor;
import start.project.higia.repositories.DoctorRepository;

@Component
public class DoctorServices {

	@Autowired
	private DoctorRepository repository; 
	
	//Serviço para salvar o doutor no banco de dados
	public Doctor create(Doctor doctor) {
		return repository.save(doctor);
	}
	
}
