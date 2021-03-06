package traveller.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import traveller.dtos.DriverDTO;
import traveller.model.coach.Coach;
import traveller.model.driver.Driver;
import traveller.model.driver.DriverDetails;
import traveller.model.tour.Tour;
import traveller.repositories.coach.CoachRepository;
import traveller.repositories.driver.DriverDetailsRepository;
import traveller.repositories.driver.DriverRepository;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DriverService {

    @Autowired
    DriverDetailsRepository driverDetailsRepository;
    @Autowired
    DriverRepository driverRepository;
    @Autowired
    CoachRepository coachRepository;

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
    public List<DriverDTO> findAllDriversByTourId(Long id) {

        List<DriverDetails> loadedDrivers = driverDetailsRepository.findAllByTourId(id);
        return createDriverDtoList(loadedDrivers);
    }
    public List<DriverDTO> findAvailableDrivers() {

        List<DriverDetails> loadedDrivers = driverDetailsRepository.findAll();
        return createDriverDtoList(loadedDrivers);
    }
    public boolean checkPhone(String phone) {

        Boolean check = driverDetailsRepository.isPhoneUsed(phone);
        return check != null ? check : false;
    }
    public String findPhoneByDriverId(Long id) {

        return driverDetailsRepository.findPhoneByDriverId(id);
    }
    public boolean checkEmail(String email) {

        Boolean check = driverDetailsRepository.isEmailUsed(email);
        return check != null ? check : false;
    }
    public String findEmailByDriverId(Long id) {

        return driverDetailsRepository.findEmailByDriverId(id);
    }
    public void addDriver(DriverDTO form) {

        Driver driver = new Driver();
        saveDriverInDB(driver, form);
        DriverDetails driverDetails = new DriverDetails();
        saveDriverDetailsInDB(driverDetails, driver, form);
    }
    public void editDriver(DriverDTO form) {

        Driver driver = driverRepository.findOne(form.getId());
        saveDriverInDB(driver, form);
        DriverDetails driverDetails = driverDetailsRepository.findByDriverId(form.getId());
        saveDriverDetailsInDB(driverDetails, driver, form);
    }
    public void deleteDriver(Long id) {

        driverDetailsRepository.delete(driverDetailsRepository.findByDriverId(id));
        driverRepository.delete(id);
    }
    private void saveDriverInDB(Driver driver, DriverDTO confirmedDriver) {

        driver.setFirstName(confirmedDriver.getFirstName());
        driver.setLastName(confirmedDriver.getLastName());
        driver.setCoach(coachRepository.findOne(confirmedDriver.getCoachId()));
        //TODO setTours
        driverRepository.save(driver);
    }
    private void saveDriverDetailsInDB(DriverDetails driverDetails, Driver driver, DriverDTO confirmedDriver) {

        driverDetails.setPhone(confirmedDriver.getPhone());
        driverDetails.setEmail(confirmedDriver.getEmail());
        driverDetails.setDriver(driver);
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
