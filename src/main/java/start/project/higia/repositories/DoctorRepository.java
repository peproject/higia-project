package start.project.higia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import start.project.higia.models.Doctor;

@Component
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	public Doctor findByEmailAndPassword(String email, String password);

}
