package traveller.model.driver;

import javax.persistence.*;

@Entity
@Table(name = "drivers_details")
public class DriverDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String phone;
    @Column(nullable = false, unique = true)
    private String email;
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Driver driver;

    public Long getId() {

        return id;
    }
    public void setId(Long id) {

        this.id = id;
    }
    public String getPhone() {

        return phone;
    }
    public void setPhone(String phone) {

        this.phone = phone;
    }
    public String getEmail() {

        return email;
    }
    public void setEmail(String email) {

        this.email = email;
    }
    public Driver getDriver() {

        return driver;
    }
    public void setDriver(Driver driver) {

        this.driver = driver;
    }
}
