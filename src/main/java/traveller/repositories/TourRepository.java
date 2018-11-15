package traveller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import traveller.model.Tour;

public interface TourRepository extends JpaRepository<Tour, Long> {
}
