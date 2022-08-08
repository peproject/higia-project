package start.project.higia.security;

import java.util.Calendar;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import start.project.higia.models.UserPasswordTokens;
import start.project.higia.repositories.UserPasswordTokensRepository;

@Service
@Transactional
public class UserSecurityService implements IUserSecurity {

	@Autowired
	private UserPasswordTokensRepository userPasswordTokensRepository;
	
    @Override
    public String validatePasswordResetToken(String token) {
        final UserPasswordTokens passToken =  userPasswordTokensRepository.findByToken(token);

        return !isTokenFound(passToken) ? "invalidToken"
                : isTokenExpired(passToken) ? "expired"
                : null;
    }

    private boolean isTokenFound(UserPasswordTokens passToken) {
        return passToken != null;
    }

    private boolean isTokenExpired(UserPasswordTokens passToken) {
        final Calendar cal = Calendar.getInstance();
        return passToken.getExpiryDate().before(cal.getTime());
    }
	
}
