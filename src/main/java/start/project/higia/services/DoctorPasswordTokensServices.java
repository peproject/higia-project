package start.project.higia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import start.project.higia.models.DoctorPasswordTokens;
import start.project.higia.repositories.DoctorPasswordTokensRepository;
import start.project.higia.utils.Salt;

@Component
public class DoctorPasswordTokensServices {

	@Autowired
	DoctorPasswordTokensRepository doctorPasswordTokensRepository;
	
	public DoctorPasswordTokens create(DoctorPasswordTokens doctor) {		
		doctor.setTokens(Salt.generateType1UUID().toString());
		doctor.setUsed(0);
		return doctorPasswordTokensRepository.save(doctor);
	}
	
}
 