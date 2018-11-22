package traveller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import traveller.model.Driver;
import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    Driver findById(Long id);
    List<Driver> findAllByCoachId(Long id);
}
