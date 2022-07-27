package start.project.higia.repositories;

<<<<<<< HEAD
import java.util.Optional;
=======
>>>>>>> 0c3ed74a1aa88e265d572c8ff553a6b49d2cc1b8

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import start.project.higia.models.Doctor;

@Component
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	public Doctor findByEmailAndPassword(String email, String password);
	public Doctor findByEmail(String email);
	
<<<<<<< HEAD
	@Query("select u from Doctor u where u.email = :email")
	Optional<Doctor> findBEmail(@Param("email") String email);
	
=======
>>>>>>> 0c3ed74a1aa88e265d572c8ff553a6b49d2cc1b8
}
