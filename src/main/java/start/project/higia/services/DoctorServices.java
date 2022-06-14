package start.project.higia.services;

import java.util.List;
import java.util.Optional;

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
	
	//Serviço para editar o doutor
	public Optional<Doctor> editById(Long id) {
		return repository.findById(id);
	}
    //Serviço para  deletar o doutor 
	public String deleteById(Long id) {
		repository.deleteById(id);
		return "";
	}
	
	
}
