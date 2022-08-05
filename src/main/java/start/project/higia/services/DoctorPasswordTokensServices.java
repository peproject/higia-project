package start.project.higia.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

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
	
	private static final int passwordComplexity = 10;
	
	public void create(final Doctor doctor, final String token) {
        final DoctorPasswordTokens myToken = new DoctorPasswordTokens(token, doctor);
        doctorPasswordTokensRepository.save(myToken);
    }
	
    public Optional<Doctor> getDoctorByPasswordResetToken(final String token) {
        return Optional.ofNullable(doctorPasswordTokensRepository.findByToken(token) .getDoctor());
    }
    
    public void changePassword(Doctor doctor, String password) {
        doctor.setPassword(BCrypt.hashpw(password, BCrypt.gensalt(passwordComplexity)));
        doctorRepositoy.save(doctor); 
    }
}
 