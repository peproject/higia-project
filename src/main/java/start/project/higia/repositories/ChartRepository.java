package start.project.higia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import start.project.higia.models.Chart;

@Component
public interface ChartRepository extends JpaRepository<Chart, Long> {

}
