package start.project.higia.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import start.project.higia.models.User;

@Component
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT u From User u WHERE u.email LIKE :email")
	User findEmail(@Param("email") String  email);
	
	public Optional<User> findByEmail(String email);
	
	User findByCpf (String cpf);
}
