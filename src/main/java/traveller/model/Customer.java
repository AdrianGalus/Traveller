package traveller.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String fistName;
    @Column(nullable = false)
    private String lastName;
    @OneToMany(mappedBy = "customer")
    private List<Tour> tours;

    public Long getId() {

        return id;
    }
    public void setId(Long id) {

        this.id = id;
    }
    public String getFistName() {

        return fistName;
    }
    public void setFistName(String fistName) {

        this.fistName = fistName;
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
