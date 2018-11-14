package traveller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import traveller.model.Coach;

public interface CoachRepository extends JpaRepository<Coach, Long> {

    @Query("SELECT true FROM Coach c WHERE c.registrationNumber = :registerNumber")
    Boolean isRegisterNumberUsed(String registerNumber);
}
