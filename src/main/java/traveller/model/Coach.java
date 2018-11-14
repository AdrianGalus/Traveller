package traveller.model;

import org.hibernate.annotations.JoinFormula;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "coaches")
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String registrationNumber;
    @OneToMany(mappedBy = "coach", fetch = FetchType.EAGER)
    private List<Driver> drivers = new ArrayList<>();
    @OneToMany(mappedBy = "coach")
    private List<Tour> allTours;
    @OneToMany(mappedBy = "coach")
    @JoinFormula("SELECT t FROM Tour t WHERE t.coachId = :id AND t.arrivalDate > now()")
    private List<Tour> plannedTours;

    public Long getId() {

        return id;
    }
    public void setId(Long id) {

        this.id = id;
    }
    public String getRegistrationNumber() {

        return registrationNumber;
    }
    public void setRegistrationNumber(String registrationNumber) {

        this.registrationNumber = registrationNumber;
    }
    public List<Driver> getDrivers() {

        return drivers;
    }
    public void setDrivers(List<Driver> drivers) {

        this.drivers = drivers;
    }
    public List<Tour> getAllTours() {

        return allTours;
    }
    public void setAllTours(List<Tour> allTours) {

        this.allTours = allTours;
    }
    public List<Tour> getPlannedTours() {

        return plannedTours;
    }
    public void setPlannedTours(List<Tour> plannedTours) {

        this.plannedTours = plannedTours;
    }
}
