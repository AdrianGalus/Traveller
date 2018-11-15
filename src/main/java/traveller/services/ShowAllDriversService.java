package traveller.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveller.dtos.DriverDTO;
import traveller.model.DriverDetails;
import traveller.repositories.DriverDetailsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowAllDriversService {

    @Autowired
    DriverDetailsRepository driverDetailsRepository;

    public List<DriverDTO> showAllDrivers() {
        List<DriverDetails> loadedDrivers = driverDetailsRepository.findAll();
        List<DriverDTO> driversDTO = new ArrayList<>();
        for(DriverDetails d : loadedDrivers) {
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
