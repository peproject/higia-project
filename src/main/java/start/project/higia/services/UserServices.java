package start.project.higia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import start.project.higia.models.User;
import start.project.higia.repositories.UserRepository;

@Component
public class UserServices {

	@Autowired
	private UserRepository repository;
	
	public User create(User user) {
		return repository.save(user);
	}
	
}
