package start.project.higia.repositories;

import java.util.Date;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import start.project.higia.models.Doctor;
import start.project.higia.models.DoctorPasswordTokens;

@Component
public interface DoctorPasswordTokensRepository extends JpaRepository<DoctorPasswordTokens, Long> {
	
	DoctorPasswordTokens findByToken(String token);

	DoctorPasswordTokens findByDoctor(Doctor doctor);

    Stream<DoctorPasswordTokens> findAllByExpiryDateLessThan(Date now);

    void deleteByExpiryDateLessThan(Date now);

	
}
