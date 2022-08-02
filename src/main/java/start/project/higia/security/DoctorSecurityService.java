package start.project.higia.security;

import java.util.Calendar;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import start.project.higia.models.DoctorPasswordTokens;
import start.project.higia.repositories.DoctorPasswordTokensRepository;

@Service
@Transactional
public class DoctorSecurityService implements ISecurityService{

	@Autowired
	private DoctorPasswordTokensRepository doctorPasswordTokensRepository;
	
    @Override
    public String validatePasswordResetToken(String token) {
        final DoctorPasswordTokens passToken = doctorPasswordTokensRepository.findByToken(token);

        return !isTokenFound(passToken) ? "invalidToken"
                : isTokenExpired(passToken) ? "expired"
                : null;
    }

    private boolean isTokenFound(DoctorPasswordTokens passToken) {
        return passToken != null;
    }

    private boolean isTokenExpired(DoctorPasswordTokens passToken) {
        final Calendar cal = Calendar.getInstance();
        return passToken.getExpiryDate().before(cal.getTime());
    }
}
