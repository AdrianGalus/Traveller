package traveller.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveller.dtos.DriverDTO;
import traveller.model.Driver;
import traveller.model.DriverDetails;
import traveller.repositories.DriverDetailsRepository;
import traveller.repositories.DriverRepository;

@Service
public class AddDriverService {

    @Autowired
    DriverRepository driverRepository;
    @Autowired
    DriverDetailsRepository driverDetailsRepository;

    public void addDriver(DriverDTO form) {

        Driver driver = new Driver();
        driver.setFirstName(form.getFirstName());
        driver.setLastName(form.getLastName());
        driverRepository.save(driver);
        DriverDetails driverDetails = new DriverDetails();
        driverDetails.setDriver(driver);
        driverDetails.setPhone(form.getPhone());
        driverDetails.setEmail(form.getEmail());
        driverDetailsRepository.save(driverDetails);
    }
}
