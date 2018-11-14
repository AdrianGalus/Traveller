package traveller.dtos;

import traveller.model.Coach;
import traveller.model.Customer;
import traveller.model.Driver;
import java.time.LocalDateTime;
import java.util.List;

public class TourDTO {

    private Integer id;
    private Coach coach;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Customer customer;
    private List<Driver> drivers;

    public Integer getId() {

        return id;
    }
    public void setId(Integer id) {

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
