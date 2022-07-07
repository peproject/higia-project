package start.project.higia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import start.project.higia.models.Doctor;
import start.project.higia.models.Roles;
import start.project.higia.repositories.DoctorRepository;

@Component
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	// Serviço para salvar o doutor no banco de dados
	public Doctor create(Doctor doctor) {
		doctor.setRole(Roles.DOCTOR);
		return doctorRepository.save(doctor);
	}

	// Serviço para listar o doutor
	public List<Doctor> index(Doctor doctor) {
		return doctorRepository.findAll();
	}

	// Serviço para editar o doutor
	public Optional<Doctor> editById(Long id) {
		return doctorRepository.findById(id);
	}

	// Serviço para deletar o doutor
	public String deleteById(Long id) {
		doctorRepository.deleteById(id);
		return "";
	}

	public Doctor findByEmailAndPassword(String email, String password) {
		return doctorRepository.findByEmailAndPassword(email, password);
	}

}
