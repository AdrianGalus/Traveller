package traveller.model;

import java.time.LocalDateTime;

public class Tour {

    private Integer id;
    private Coach coach;
    private String destination;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;

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
}
