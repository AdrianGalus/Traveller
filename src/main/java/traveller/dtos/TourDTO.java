package traveller.dtos;

import org.hibernate.validator.constraints.NotBlank;
import traveller.model.Coach;
import traveller.model.Customer;
import traveller.model.Driver;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

public class TourDTO {

    private Long id;
    @NotNull @NotBlank
    private Coach coach;
    @NotNull @NotBlank
    private String destination;
    @NotNull @NotBlank
    private LocalDateTime departureTime;
    @NotNull @NotBlank
    private LocalDateTime arrivalTime;
    private Customer customer;
    @NotNull @NotBlank
    private List<Driver> drivers;

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
    public LocalDateTime getDepartureTime() {

        return departureTime;
    }
    public void setDepartureTime(LocalDateTime departureTime) {

        this.departureTime = departureTime;
    }
    public LocalDateTime getArrivalTime() {

        return arrivalTime;
    }
    public void setArrivalTime(LocalDateTime arrivalTime) {

        this.arrivalTime = arrivalTime;
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
