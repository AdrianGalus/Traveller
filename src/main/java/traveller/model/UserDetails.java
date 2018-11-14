package traveller.model;

import javax.persistence.*;

@Entity
@Table(name = "users_details")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private User user;

    public Integer getId() {

        return id;
    }
    public void setId(Integer id) {

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
    public User getUser() {

        return user;
    }
    public void setUser(User user) {

        this.user = user;
    }
}
