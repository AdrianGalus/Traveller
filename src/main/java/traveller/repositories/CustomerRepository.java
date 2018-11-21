package traveller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import traveller.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT true FROM Customer c WHERE c.nip = :nip")
    Boolean isNipUsed(@Param("nip") String nip);
}
