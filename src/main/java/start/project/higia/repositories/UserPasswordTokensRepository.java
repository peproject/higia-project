package start.project.higia.repositories;

import java.util.Date;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;

import start.project.higia.models.User;
import start.project.higia.models.UserPasswordTokens;

public interface UserPasswordTokensRepository extends JpaRepository<UserPasswordTokens, Long>  {

	UserPasswordTokens findByToken(String token);

	UserPasswordTokens findByDoctor(User user);

    Stream<UserPasswordTokens> findAllByExpiryDateLessThan(Date now);

    void deleteByExpiryDateLessThan(Date now);
	
	
}
