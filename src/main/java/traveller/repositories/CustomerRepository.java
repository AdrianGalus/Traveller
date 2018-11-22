package traveller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import traveller.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
