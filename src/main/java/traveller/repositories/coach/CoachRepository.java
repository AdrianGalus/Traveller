package traveller.repositories.coach;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import traveller.model.coach.Coach;

public interface CoachRepository extends JpaRepository<Coach, Long> {

    @Query("SELECT true FROM Coach c WHERE c.registrationNumber = :registrationNumber")
    Boolean isRegistrationNumberUsed(@Param("registrationNumber") String registrationNumber);
    @Query("SELECT c.registrationNumber FROM Coach c WHERE c.id = :id")
    String findRegistrationNumberByCoachId(@Param("id") Long id);
}
