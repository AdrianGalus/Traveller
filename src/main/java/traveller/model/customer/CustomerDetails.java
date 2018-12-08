package traveller.model.customer;

import javax.persistence.*;

@Entity
@Table(name = "customers_details")
public class CustomerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String phone;
    @Column(nullable = false, unique = true)
    private String email;
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Customer customer;

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
    public Customer getCustomer() {

        return customer;
    }
    public void setCustomer(Customer customer) {

        this.customer = customer;
    }
}
