package traveller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import traveller.model.TourDetails;

public interface TourDetailsRepository extends JpaRepository<TourDetails, Long> {
}
