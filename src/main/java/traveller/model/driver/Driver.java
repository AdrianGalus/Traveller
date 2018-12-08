package traveller.model.driver;

import traveller.model.tour.Tour;
import traveller.model.coach.Coach;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @ManyToOne
    private Coach coach;
    @ManyToMany
    private List<Tour> tours = new ArrayList<>();

    public Long getId() {

        return id;
    }
    public void setId(Long id) {

        this.id = id;
    }
    public String getFirstName() {

        return firstName;
    }
    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }
    public String getLastName() {

        return lastName;
    }
    public void setLastName(String lastName) {

        this.lastName = lastName;
    }
    public Coach getCoach() {

        return coach;
    }
    public void setCoach(Coach coach) {

        this.coach = coach;
    }
    public List<Tour> getTours() {

        return tours;
    }
    public void setTours(List<Tour> tours) {

        this.tours = tours;
    }
}
