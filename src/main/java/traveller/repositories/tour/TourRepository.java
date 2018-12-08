package traveller.repositories.tour;

import org.springframework.data.jpa.repository.JpaRepository;
import traveller.model.tour.Tour;

public interface TourRepository extends JpaRepository<Tour, Long> {
}
