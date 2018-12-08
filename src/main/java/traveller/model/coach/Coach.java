package traveller.model.coach;

import traveller.model.driver.Driver;
import traveller.model.tour.Tour;

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
    private List<Tour> tours = new ArrayList<>();

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
    public List<Tour> getTours() {

        return tours;
    }
    public void setTours(List<Tour> tours) {

        this.tours = tours;
    }
}
