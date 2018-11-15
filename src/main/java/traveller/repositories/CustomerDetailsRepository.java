package traveller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import traveller.model.CustomerDetails;

public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Long> {
}
