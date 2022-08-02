package start.project.higia.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.password.PasswordEncoder;
import start.project.higia.models.Doctor;
import start.project.higia.models.DoctorPasswordTokens;
import start.project.higia.repositories.DoctorPasswordTokensRepository;
import start.project.higia.repositories.DoctorRepository;

@Component
public class DoctorPasswordTokensServices {

	@Autowired
	DoctorPasswordTokensRepository doctorPasswordTokensRepository;
	
	@Autowired
	DoctorRepository doctorRepositoy;

    @Autowired
    private PasswordEncoder passwordEncoder;
	
	public void create(final Doctor doctor, final String token) {
        final DoctorPasswordTokens myToken = new DoctorPasswordTokens(token, doctor);
        doctorPasswordTokensRepository.save(myToken);
    }
	
    public Optional<Doctor> getDoctorByPasswordResetToken(final String token) {
        return Optional.ofNullable(doctorPasswordTokensRepository.findByToken(token) .getDoctor());
    }
    

}
 