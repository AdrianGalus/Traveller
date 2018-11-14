package traveller.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tours_details")
public class TourDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Customer customer;
    @ManyToMany
    private List<Driver> drivers = new ArrayList<>();

    public Long getId() {

        return id;
    }
    public void setId(Long id) {

        this.id = id;
    }
    public Customer getCustomer() {

        return customer;
    }
    public void setCustomer(Customer customer) {

        this.customer = customer;
    }
    public List<Driver> getDrivers() {

        return drivers;
    }
    public void setDrivers(List<Driver> drivers) {

        this.drivers = drivers;
    }
}
