package traveller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import traveller.model.DriverDetails;

public interface DriverDetailsRepository extends JpaRepository<DriverDetails, Long> {
}
