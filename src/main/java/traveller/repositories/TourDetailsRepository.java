package traveller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import traveller.model.TourDetails;
import java.util.List;

public interface TourDetailsRepository extends JpaRepository<TourDetails, Long> {

    @Query("SELECT td FROM TourDetails td WHERE td.tour.id = :id")
    TourDetails findByTourId(@Param("id") Long id);
    @Query("SELECT td FROM TourDetails td WHERE td.tour.coach.id = :id")
    List<TourDetails> findAllByCoachId(@Param("id") Long id);
    @Query("SELECT td FROM TourDetails td WHERE td.tour.customer.id = :id")
    List<TourDetails> findAllByCustomerId(@Param("id") Long id);
    @Query("SELECT td FROM TourDetails td JOIN td.tour.drivers d WHERE d.id = :id")
    List<TourDetails> findAllByDriverId(@Param("id") Long id);
}
