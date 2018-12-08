package traveller.repositories.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import traveller.model.customer.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
