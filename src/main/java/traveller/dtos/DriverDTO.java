package traveller.dtos;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class DriverDTO {

    private Long id;
    @NotNull @NotBlank @Size(min = 3)
    private String firstName;
    @NotNull @NotBlank @Size(min = 3)
    private String lastName;
    private Long coachId;
    private List<Long> toursId;
    @NotNull @NotBlank
    private String phone;
    @NotNull @NotBlank @Email
    private String email;

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
    public Long getCoachId() {

        return coachId;
    }
    public void setCoachId(Long coachId) {

        this.coachId = coachId;
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
        return "DriverDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", coachId=" + coachId +
                ", toursId=" + toursId +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
