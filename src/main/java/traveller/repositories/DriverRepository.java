package traveller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import traveller.model.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    Driver findById(Long id);
}
