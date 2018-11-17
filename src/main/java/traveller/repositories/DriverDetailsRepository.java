package traveller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import traveller.model.DriverDetails;

public interface DriverDetailsRepository extends JpaRepository<DriverDetails, Long> {

    @Query("SELECT true FROM DriverDetails dd WHERE dd.phone = :phone")
    Boolean isPhoneUsed(@Param("phone") String phone);
    @Query("SELECT true FROM DriverDetails dd WHERE dd.email = :email")
    Boolean isEmailUsed(@Param("email") String email);
}
