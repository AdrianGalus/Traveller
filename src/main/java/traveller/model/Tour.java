package traveller.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tours")
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Coach coach;
    @Column(nullable = false)
    private String destination;
    @Column(nullable = false)
    private LocalDateTime departureDate;
    @Column(nullable = false)
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
