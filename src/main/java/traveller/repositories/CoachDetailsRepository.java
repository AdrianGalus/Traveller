package traveller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import traveller.model.CoachDetails;

public interface CoachDetailsRepository extends JpaRepository<CoachDetails, Long> {

    @Query("SELECT cd FROM CoachDetails cd WHERE cd.coach.id = :id")
    CoachDetails findByCoachId(@Param("id") Long id);
}
