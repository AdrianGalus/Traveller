package traveller.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import traveller.dtos.DriverDTO;
import traveller.model.Coach;
import traveller.model.Driver;
import traveller.model.DriverDetails;
import traveller.model.Tour;
import traveller.repositories.DriverDetailsRepository;
import traveller.repositories.DriverRepository;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DriverService {

    @Autowired
    DriverDetailsRepository driverDetailsRepository;
    @Autowired
    DriverRepository driverRepository;

    public DriverDTO findDetails(Long id) {

        DriverDTO driverDTO = new DriverDTO();
        Driver loadedDriver = driverRepository.findOne(id);
        DriverDetails loadedDriverDetails = driverDetailsRepository.findByDriverId(id);
        driverDTO.setId(loadedDriverDetails.getDriver().getId());
        driverDTO.setFirstName(loadedDriver.getFirstName());
        driverDTO.setLastName(loadedDriver.getLastName());
        driverDTO.setPhone(loadedDriverDetails.getPhone());
        driverDTO.setEmail(loadedDriverDetails.getEmail());
        Coach coach = loadedDriver.getCoach();
        if(coach != null) {
            driverDTO.setCoachId(coach.getId());
        }
        List<Long> toursId = new ArrayList<>();
        for(Tour t : loadedDriver.getTours()) {
            toursId.add(t.getId());
        }
        driverDTO.setToursId(toursId);
        return driverDTO;
    }
    public List<DriverDTO> findAllDrivers() {

        List<DriverDetails> loadedDrivers = driverDetailsRepository.findAll();
        return createDriverDtoList(loadedDrivers);
    }
    public List<DriverDTO> findAllDriversByCoachId(Long id) {

        List<DriverDetails> loadedDrivers = driverDetailsRepository.findAllByCoachId(id);
        return createDriverDtoList(loadedDrivers);
    }
    public boolean checkPhone(String phone) {

        Boolean check = driverDetailsRepository.isPhoneUsed(phone);
        return check != null ? check : false;
    }
    public boolean checkEmail(String email) {

        Boolean check = driverDetailsRepository.isEmailUsed(email);
        return check != null ? check : false;
    }
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
    private List<DriverDTO> createDriverDtoList(List<DriverDetails> loadedDriverDetails) {

        List<DriverDTO> driversDTO = new ArrayList<>();
        for(DriverDetails d : loadedDriverDetails) {
            DriverDTO driverDTO = new DriverDTO();
            driverDTO.setId(d.getDriver().getId());
            driverDTO.setFirstName(d.getDriver().getFirstName());
            driverDTO.setLastName(d.getDriver().getLastName());
            driverDTO.setPhone(d.getPhone());
            driverDTO.setEmail(d.getEmail());
            driversDTO.add(driverDTO);
        }
        return driversDTO;
    }
}
