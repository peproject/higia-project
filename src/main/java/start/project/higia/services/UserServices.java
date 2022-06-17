package start.project.higia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import start.project.higia.models.User;
import start.project.higia.repositories.UserRepository;

@Component
public class UserServices {

	@Autowired
	private UserRepository repository;

	//Serviço para salvar o user no banco
	public User create(User user) {

		user.setRole();
		return repository.save(user);
	}

	//Serviço para exibir todos os usuarios
	public List<User> index (User user) {
		return repository.findAll();
	}

	public Optional<User> editById(Long id) {
		return repository.findById(id);
	}

	public String deleteById(Long id) {
		repository.deleteById(id);
		return "";
	}

	//Rota para encontrar o user
<<<<<<< HEAD
	public User findByEmailAndSenha(String email, String password) {
=======
	public User findByEmailAndPassword(String email, String password) {
>>>>>>> a8bca30844d736ad79e0c1daa912c837dbc49381

		return repository.findByEmailAndPassword(email, password);
	}
}
