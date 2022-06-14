package start.project.higia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import start.project.higia.models.User;

@Component
public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByEmailAndPassword(String email, String password);
}
