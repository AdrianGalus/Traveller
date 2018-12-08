package traveller.repositories.driver;

import org.springframework.data.jpa.repository.JpaRepository;
import traveller.model.driver.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long> {

}
