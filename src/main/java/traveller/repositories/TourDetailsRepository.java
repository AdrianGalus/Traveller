package traveller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import traveller.model.TourDetails;

public interface TourDetailsRepository extends JpaRepository<TourDetails, Long> {

    @Query("SELECT td FROM TourDetails td WHERE td.tour.id = :id")
    TourDetails findByTourId(@Param("id") Long id);
}
