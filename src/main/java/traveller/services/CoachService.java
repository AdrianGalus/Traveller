package traveller.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import traveller.dtos.CoachDTO;
import traveller.model.Coach;
import traveller.model.CoachDetails;
import traveller.model.Driver;
import traveller.model.Tour;
import traveller.repositories.CoachDetailsRepository;
import traveller.repositories.CoachRepository;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CoachService {

    @Autowired
    CoachRepository coachRepository;
    @Autowired
    CoachDetailsRepository coachDetailsRepository;

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
        List<CoachDTO> coachesDTO = new ArrayList<>();
        for(CoachDetails c : loadedCoaches) {
            CoachDTO coachDTO = new CoachDTO();
            coachDTO.setId(c.getCoach().getId());
            coachDTO.setRegistrationNumber(c.getCoach().getRegistrationNumber());
            coachDTO.setModel(c.getModel());
            coachDTO.setMark(c.getMark());
            coachesDTO.add(coachDTO);
        }
        return coachesDTO;
    }
    public boolean checkRegistrationNumber(String registrationNumber) {

        Boolean check = coachRepository.isRegistrationNumberUsed(registrationNumber);
        return check != null ? check : false;
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
}
