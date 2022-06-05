package start.project.higia.services;

import java.util.List;

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
	
	//Serviço para listar o doutor
	public List<Doctor> index(Doctor doctor) {
	   return repository.findAll();
	}
	
}
