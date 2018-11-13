package traveller.model;

import java.util.ArrayList;
import java.util.List;

public class TourDetails {

    private Integer id;
    private Customer customer;
    private List<Driver> drivers = new ArrayList<>();

    public Integer getId() {

        return id;
    }
    public void setId(Integer id) {

        this.id = id;
    }
    public Customer getCustomer() {

        return customer;
    }
    public void setCustomer(Customer customer) {

        this.customer = customer;
    }
    public List<Driver> getDrivers() {

        return drivers;
    }
    public void setDrivers(List<Driver> drivers) {

        this.drivers = drivers;
    }
}
