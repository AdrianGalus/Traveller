package traveller.dtos;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class CustomerDTO {

    private Long id;

    private String name;
    @NotNull @NotBlank @Size(min = 3)
    private String firstName;
    @NotNull @NotBlank @Size(min = 3)
    private String lastName;
    @NotNull @NotBlank @Pattern(regexp = "[0-9]+")
    private String phone;
    @NotNull @NotBlank @Email
    private String email;
    private List<Long> toursId;

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
    public List<Long> getToursId() {

        return toursId;
    }
    public void setToursId(List<Long> toursId) {

        this.toursId = toursId;
    }
    @Override
    public String toString() {

        return "CustomerDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", toursId=" + toursId +
                '}';
    }
    public String getDescription() {

        return name + firstName + " " + lastName + ", phone: " + phone;
    }
}
