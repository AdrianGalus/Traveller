package traveller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import traveller.model.DriverDetails;

import java.util.List;

public interface DriverDetailsRepository extends JpaRepository<DriverDetails, Long> {

    @Query("SELECT true FROM DriverDetails dd WHERE dd.phone = :phone")
    Boolean isPhoneUsed(@Param("phone") String phone);
    @Query("SELECT true FROM DriverDetails dd WHERE dd.email = :email")
    Boolean isEmailUsed(@Param("email") String email);
    @Query("SELECT dd FROM DriverDetails dd WHERE dd.driver.id = :id")
    DriverDetails findByDriverId(@Param("id") Long id);
    @Query("SELECT dd FROM DriverDetails dd WHERE dd.driver.coach.id = :id")
    List<DriverDetails> findAllByCoachId(@Param("id") Long id);
}
