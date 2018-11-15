package traveller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import traveller.model.Customer;

public interface CustomerRepoistory extends JpaRepository<Customer, Long> {
}
