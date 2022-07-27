package start.project.higia.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import start.project.higia.models.Doctor;

@Component
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	public Doctor findByEmailAndPassword(String email, String password);

	public Doctor findByEmail(String email);
	
	@Query("select u from Doctor u where u.email = :email")
	Optional<Doctor> findBEmail(@Param("email") String email);
	
}
