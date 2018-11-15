package traveller.dtos;

import org.hibernate.validator.constraints.NotBlank;
import traveller.model.Driver;
import traveller.model.Tour;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class CoachDTO {

    private Long id;
    @NotNull @NotBlank
    private String registrationNumber;
    private List<Driver> drivers = new ArrayList<>();
    @NotNull @NotBlank
    private String mark;
    @NotNull @NotBlank
    private String model;
    private List<Tour> tours = new ArrayList<>();

    public Long getId() {

        return id;
    }
    public void setId(Long id) {

        this.id = id;
    }
    public String getRegistrationNumber() {

        return registrationNumber;
    }
    public void setRegistrationNumber(String registrationNumber) {

        this.registrationNumber = registrationNumber;
    }
    public List<Driver> getDrivers() {

        return drivers;
    }
    public void setDrivers(List<Driver> drivers) {

        this.drivers = drivers;
    }
    public String getMark() {

        return mark;
    }
    public void setMark(String mark) {

        this.mark = mark;
    }

    public String getModel() {

        return model;
    }
    public void setModel(String model) {

        this.model = model;
    }
    public List<Tour> getTours() {

        return tours;
    }
    public void setTours(List<Tour> tours) {

        this.tours = tours;
    }
    @Override
    public String toString() {
        return registrationNumber + " " + mark + " " + model;
    }
}
