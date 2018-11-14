package traveller.model;

import javax.persistence.*;

@Entity
@Table(name = "entities")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String fistName;
    @Column(nullable = false)
    private String lastName;

    public Integer getId() {

        return id;
    }
    public void setId(Integer id) {

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
}
