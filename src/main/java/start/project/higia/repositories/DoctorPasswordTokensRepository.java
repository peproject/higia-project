package start.project.higia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import start.project.higia.models.DoctorPasswordTokens;

@Component
public interface DoctorPasswordTokensRepository extends JpaRepository<DoctorPasswordTokens, Long> {

}
