package traveller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import traveller.model.CustomerDetails;

public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Long> {

    @Query("SELECT true FROM CustomerDetails cd WHERE cd.phone = :phone")
    Boolean isPhoneUsed(@Param("phone") String phone);
    @Query("SELECT true FROM CustomerDetails cd WHERE cd.email = :email")
    Boolean isEmailUsed(@Param("email") String email);
    @Query("SELECT cd FROM CustomerDetails cd WHERE cd.customer.id = :id")
    CustomerDetails findByCustomerId(@Param("id") Long id);
}
