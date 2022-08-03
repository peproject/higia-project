package start.project.higia.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import start.project.higia.models.Doctor;

@Component
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	
	@Query("SELECT u From Doctor u WHERE u.email LIKE :email")
	Doctor findEmail(@Param("email") String  email);
	
	public Optional<Doctor> findByEmail(String email);

	
}
