package traveller.dtos;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import traveller.model.Tour;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class DriverDTO {

    private Long id;
    @NotNull @NotBlank @Size(min = 3)
    private String firstName;
    @NotNull @NotBlank @Size(min = 3)
    private String lastName;
    @NotNull @NotBlank
    private String phone;
    @NotNull @NotBlank @Email
    private String email;
    private List<Tour> tours;

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
    public List<Tour> getTours() {

        return tours;
    }
    public void setTours(List<Tour> tours) {

        this.tours = tours;
    }
}
