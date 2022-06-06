package start.project.higia.services;

import java.util.List;

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
		return repository.save(user);
	}
	
	//Serviço para exibir todos os usuarios
	public List<User> index (User user) {
		return repository.findAll();
	}
	
}
