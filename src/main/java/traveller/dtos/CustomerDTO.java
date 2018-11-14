package traveller.dtos;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import traveller.model.Tour;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class CustomerDTO {

    private Integer id;
    @NotNull @NotBlank @Size(min = 3)
    private String firstName;
    @NotNull @NotBlank @Size(min = 3)
    private String lastName;
    @NotNull @NotBlank
    private String phone;
    @NotNull @NotBlank @Email
    private String email;
    private List<Tour> tours;
}
