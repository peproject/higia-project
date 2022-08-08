package start.project.higia.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import start.project.higia.models.User;
import start.project.higia.models.UserPasswordTokens;
import start.project.higia.repositories.UserPasswordTokensRepository;
import start.project.higia.repositories.UserRepository;

@Component
public class UserPasswordTokensServices {

	@Autowired
	UserPasswordTokensRepository userPasswordTokensRepository;
	
	@Autowired
	UserRepository userRepositoy;
	
	private static final int passwordComplexity = 10;
	
	public void create(final User user, final String token) {
        final UserPasswordTokens myToken = new UserPasswordTokens(token, user);
        userPasswordTokensRepository.save(myToken);
    }
	
    public Optional<User> getDoctorByPasswordResetToken(final String token) {
        return Optional.ofNullable(userPasswordTokensRepository.findByToken(token).getUser());
    }
    
    public void changePassword(User user, String password) {
        user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt(passwordComplexity)));
        userRepositoy.save(user); 
    }
	
}
