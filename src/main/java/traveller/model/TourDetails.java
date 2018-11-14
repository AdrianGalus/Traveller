package traveller.model;

import javax.persistence.*;

@Entity
@Table(name = "tours_details")
public class TourDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double price;
    private Double distance;
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Tour tour;

    public Long getId() {

        return id;
    }
    public void setId(Long id) {

        this.id = id;
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
    public Tour getTour() {

        return tour;
    }
    public void setTour(Tour tour) {

        this.tour = tour;
    }
}
