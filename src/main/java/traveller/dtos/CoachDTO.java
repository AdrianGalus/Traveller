package traveller.dtos;

import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class CoachDTO {

    private Long id;
    @NotNull @NotBlank
    private String registrationNumber;
    private List<Long> driversId = new ArrayList<>();
    @NotNull @NotBlank
    private String mark;
    @NotNull @NotBlank
    private String model;
    private List<Long> toursId = new ArrayList<>();

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
    public List<Long> getDriversId() {

        return driversId;
    }
    public void setDriversId(List<Long> driversId) {

        this.driversId = driversId;
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
    public List<Long> getToursId() {

        return toursId;
    }
    public void setToursId(List<Long> toursId) {

        this.toursId = toursId;
    }
    @Override
    public String toString() {

        return "CoachDTO{" +
                "id=" + id +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", driversId=" + driversId +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", toursId=" + toursId +
                '}';
    }
}
