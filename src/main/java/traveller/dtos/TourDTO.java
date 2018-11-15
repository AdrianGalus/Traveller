package traveller.dtos;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import traveller.model.Coach;
import traveller.model.Customer;
import traveller.model.Driver;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

public class TourDTO {

    private static final String DATE_FORMAT = "uuuu-MM-dd HH:mm";

    private Long id;
    private Coach coach;
    @NotNull @NotBlank
    private String destination;
    @NotNull @DateTimeFormat(pattern = DATE_FORMAT)
    private LocalDateTime departureTime;
    @NotNull @DateTimeFormat(pattern = DATE_FORMAT)
    private LocalDateTime arrivalTime;
    private Customer customer;
    private List<Driver> drivers;
    private Double price;
    private Double distance;

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
    public Double getPrice() {

        return price;
    }
    public void setPrice(Double price) {

        this.price = price;
    }
    public Double getDistance() {

        return distance;
    }
    public void setDistance(Double distance) {

        this.distance = distance;
    }
}
