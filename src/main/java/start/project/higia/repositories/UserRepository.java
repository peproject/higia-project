package start.project.higia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import start.project.higia.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
