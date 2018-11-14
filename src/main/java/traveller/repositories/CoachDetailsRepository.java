package traveller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import traveller.model.CoachDetails;

public interface CoachDetailsRepository extends JpaRepository<CoachDetails, Long> {
}
