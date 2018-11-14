package traveller.dtos;

import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserDTO {

    private Long id;
    @NotNull @NotBlank
    private String login;
    @NotNull @NotBlank
    private String email;

    public Long getId() {

        return id;
    }
    public void setId(Long id) {

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
}
