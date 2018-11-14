package traveller.dtos;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDTO {

    private Integer id;
    @NotNull @NotBlank @Size(min = 3, max = 12)
    private String login;
    @NotNull @NotBlank @Email
    private String email;
    @NotNull @NotBlank
    private String password;
    @NotNull @NotBlank
    private String confirmedPassword;
    @NotNull @NotBlank @Size(min = 3)
    private String firstName;
    @NotNull @NotBlank @Size(min = 3)
    private String lastName;

    public Integer getId() {

        return id;
    }
    public void setId(Integer id) {

        this.id = id;
    }
    public String getLogin() {

        return login;
    }
    public void setLogin(String login) {

        this.login = login;
    }
    public String getEmail() {

        return email;
    }
    public void setEmail(String email) {

        this.email = email;
    }
    public String getPassword() {

        return password;
    }
    public void setPassword(String password) {

        this.password = password;
    }
    public String getConfirmedPassword() {

        return confirmedPassword;
    }
    public void setConfirmedPassword(String confirmedPassword) {

        this.confirmedPassword = confirmedPassword;
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
}
