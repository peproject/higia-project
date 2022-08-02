package start.project.higia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import start.project.higia.models.Roles;
import start.project.higia.models.User;
import start.project.higia.repositories.UserRepository;

@Component
public class UserService {

	@Autowired
	private UserRepository userRepository;

	private static final int passwordComplexity = 10;
	
	//Serviço para salvar o user no banco
	public User create(User user) {
		user.setRole(Roles.USER);
		return userRepository.save(user);
	}
	
	public String encryptPassword(User user) {
		return BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(passwordComplexity));
	}

	//Serviço para exibir todos os usuarios
	public List<User> index(User user) {
		return userRepository.findAll();
	}

	public Optional<User> editById(Long id) {
		return userRepository.findById(id);
	}

	public String deleteById(Long id) {
		userRepository.deleteById(id);
		return "";
	}

	//Rota para encontrar o user
	public User findByEmailAndPassword(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}
}
