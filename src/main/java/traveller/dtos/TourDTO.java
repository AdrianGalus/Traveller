package traveller.dtos;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TourDTO {

    private static final String DATE_FORMAT = "uuuu-MM-dd HH:mm";
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern(DATE_FORMAT);

    private Long id;
    private Long coachId;
    @NotNull @NotBlank
    private String destination;
    @NotNull @DateTimeFormat(pattern = DATE_FORMAT)
    private LocalDateTime departureTime;
    @NotNull @DateTimeFormat(pattern = DATE_FORMAT)
    private LocalDateTime arrivalTime;
    @NotNull
    private Long customerId;
    private List<Long> driversId;
    @NotNull
    private Double price;
    @NotNull
    private Double distance;

    public Long getId() {

        return id;
    }
    public void setId(Long id) {

        this.id = id;
    }
    public Long getCoachId() {

        return coachId;
    }
    public void setCoachId(Long coachId) {

        this.coachId = coachId;
    }
    public String getDestination() {

        return destination;
    }
    public void setDestination(String destination) {

        this.destination = destination;
    }
    public LocalDateTime getDepartureTime() {

        return departureTime;
    }
    public void setDepartureTime(LocalDateTime departureTime) {

        this.departureTime = departureTime;
    }
    public LocalDateTime getArrivalTime() {

        return arrivalTime;
    }
    public void setArrivalTime(LocalDateTime arrivalTime) {

        this.arrivalTime = arrivalTime;
    }
    public Long getCustomerId() {

        return customerId;
    }
    public void setCustomerId(Long customerId) {

        this.customerId = customerId;
    }
    public List<Long> getDriversId() {

        return driversId;
    }
    public void setDriversId(List<Long> driversId) {

        this.driversId = driversId;
    }
    public Double getPrice() {

        return price;
    }
    public void setPrice(Double price) {

        this.price = price;
    }
    public Double getDistance() {

        return distance;
    }
    public void setDistance(Double distance) {

        this.distance = distance;
    }
    @Override
    public String toString() {

        return "TourDTO{" +
                "id=" + id +
                ", coachId=" + coachId +
                ", destination='" + destination + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", customerId=" + customerId +
                ", driversId=" + driversId +
                ", price=" + price +
                ", distance=" + distance +
                '}';
    }
    public String getDescription() {

        return destination + " - " + departureTime.format(FORMAT) + " - " + arrivalTime.format(FORMAT);
    }
}
