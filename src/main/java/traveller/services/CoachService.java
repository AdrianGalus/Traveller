package traveller.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import traveller.dtos.CoachDTO;
import traveller.model.coach.Coach;
import traveller.model.coach.CoachDetails;
import traveller.model.driver.Driver;
import traveller.model.driver.DriverDetails;
import traveller.model.tour.Tour;
import traveller.repositories.coach.CoachDetailsRepository;
import traveller.repositories.coach.CoachRepository;
import traveller.repositories.driver.DriverDetailsRepository;
import traveller.repositories.tour.TourDetailsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CoachService {

    @Autowired
    CoachRepository coachRepository;
    @Autowired
    CoachDetailsRepository coachDetailsRepository;
    @Autowired
    DriverService driverService;
    @Autowired
    DriverDetailsRepository driverDetailsRepository;
    @Autowired
    TourDetailsRepository tourDetailsRepository;

    public CoachDTO findDetails(Long id) {

        CoachDTO coachDTO = new CoachDTO();
        Coach loadedCoach = coachRepository.findOne(id);
        CoachDetails loadedCoachDetails = coachDetailsRepository.findByCoachId(id);
        coachDTO.setId(loadedCoach.getId());
        coachDTO.setRegistrationNumber(loadedCoach.getRegistrationNumber());
        coachDTO.setModel(loadedCoachDetails.getModel());
        coachDTO.setMark(loadedCoachDetails.getMark());
        List<Long> driversId = new ArrayList<>();
        for(Driver d : loadedCoach.getDrivers()) {
            driversId.add(d.getId());
        }
        coachDTO.setDriversId(driversId);
        List<Long> toursId = new ArrayList<>();
        for(Tour t : loadedCoach.getTours()) {
            toursId.add(t.getId());
        }
        coachDTO.setToursId(toursId);
        return coachDTO;
    }
    public List<CoachDTO> findAllCoaches() {

        List<CoachDetails> loadedCoaches = coachDetailsRepository.findAll();
        return createCoachDtoList(loadedCoaches);
    }
    public List<CoachDTO> findAvailableCoaches() {

        List<CoachDetails> loadedCoaches = coachDetailsRepository.findAll();
        return createCoachDtoList(loadedCoaches);
    }
    public boolean checkRegistrationNumber(String registrationNumber) {

        Boolean check = coachRepository.isRegistrationNumberUsed(registrationNumber);
        return check != null ? check : false;
    }
    public String findRegistrationNumberByCoachId(Long id) {

        return coachRepository.findRegistrationNumberByCoachId(id);
    }
    public void addCoach(CoachDTO form) {

        Coach coach = new Coach();
        coach.setRegistrationNumber(form.getRegistrationNumber());
        coachRepository.save(coach);
        CoachDetails coachDetails = new CoachDetails();
        coachDetails.setCoach(coach);
        coachDetails.setMark(form.getMark());
        coachDetails.setModel(form.getModel());
        coachDetailsRepository.save(coachDetails);
    }
    public void editCoach(CoachDTO form) {

        Coach coach = coachRepository.findOne(form.getId());
        coach.setRegistrationNumber(form.getRegistrationNumber());
        coachRepository.save(coach);
        CoachDetails coachDetails = coachDetailsRepository.findByCoachId(form.getId());
        coachDetails.setCoach(coach);
        coachDetails.setMark(form.getMark());
        coachDetails.setModel(form.getModel());
        coachDetailsRepository.save(coachDetails);
    }
    public void deleteCoach(Long id) {

        List<DriverDetails> drivers = driverDetailsRepository.findAllByCoachId(id);
        for(DriverDetails dd : drivers) {
            dd.getDriver().setCoach(null);
        }
        coachDetailsRepository.delete(coachDetailsRepository.findByCoachId(id));
        coachRepository.delete(id);
    }
    private List<CoachDTO> createCoachDtoList(List<CoachDetails> loadedCoachesDetails) {

        List<CoachDTO> coachesDTO = new ArrayList<>();
        for(CoachDetails c : loadedCoachesDetails) {
            CoachDTO coachDTO = new CoachDTO();
            coachDTO.setId(c.getCoach().getId());
            coachDTO.setRegistrationNumber(c.getCoach().getRegistrationNumber());
            coachDTO.setModel(c.getModel());
            coachDTO.setMark(c.getMark());
            coachesDTO.add(coachDTO);
        }
        return coachesDTO;
    }
}
