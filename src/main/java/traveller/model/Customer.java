package traveller.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @OneToMany(mappedBy = "customer")
    private List<Tour> tours = new ArrayList<>();

    public Long getId() {

        return id;
    }
    public void setId(Long id) {

        this.id = id;
    }
    public String getName() {

        return name;
    }
    public void setName(String name) {

        this.name = name;
    }
    public String getFirstName() {

        return firstName;
    }
    public void setFirstName(String fistName) {

        this.firstName = fistName;
    }
    public String getLastName() {

        return lastName;
    }
    public void setLastName(String lastName) {

        this.lastName = lastName;
    }
    public List<Tour> getTours() {

        return tours;
    }
    public void setTours(List<Tour> tours) {

        this.tours = tours;
    }
}
