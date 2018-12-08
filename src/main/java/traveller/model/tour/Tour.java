package traveller.model.tour;

import traveller.model.coach.Coach;
import traveller.model.customer.Customer;
import traveller.model.driver.Driver;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tours")
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Coach coach;
    @Column(nullable = false)
    private String destination;
    @Column(nullable = false)
    private LocalDateTime departureDate;
    @Column(nullable = false)
    private LocalDateTime arrivalDate;
    @ManyToOne
    private Customer customer;
    @ManyToMany(mappedBy = "tours")
    private List<Driver> drivers = new ArrayList<>();

    public Long getId() {

        return id;
    }
    public void setId(Long id) {

        this.id = id;
    }
    public Coach getCoach() {

        return coach;
    }
    public void setCoach(Coach coach) {

        this.coach = coach;
    }
    public String getDestination() {

        return destination;
    }
    public void setDestination(String destination) {

        this.destination = destination;
    }
    public LocalDateTime getDepartureDate() {

        return departureDate;
    }
    public void setDepartureDate(LocalDateTime departureDate) {

        this.departureDate = departureDate;
    }
    public LocalDateTime getArrivalDate() {

        return arrivalDate;
    }
    public void setArrivalDate(LocalDateTime arrivalDate) {

        this.arrivalDate = arrivalDate;
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
