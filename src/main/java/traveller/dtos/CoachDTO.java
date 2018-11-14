package traveller.dtos;

import org.hibernate.validator.constraints.NotBlank;
import traveller.model.Driver;
import traveller.model.Tour;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class CoachDTO {

    private Integer id;
    @NotNull @NotBlank
    private String registrationNumber;
    @NotNull @NotBlank
    private List<Driver> drivers = new ArrayList<>();
    private String mark;
    private String model;
    private List<Tour> tours = new ArrayList<>();
}
