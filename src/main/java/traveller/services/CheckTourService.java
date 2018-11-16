package traveller.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveller.dtos.CoachDTO;
import traveller.model.CoachDetails;
import traveller.repositories.CoachDetailsRepository;
import java.util.ArrayList;
import java.util.List;

@Service
public class CheckTourService {

    @Autowired
    CoachDetailsRepository coachDetailsRepository;

    public List<CoachDTO> loadAvailableCoaches() {

        List<CoachDetails> loadedCoaches = coachDetailsRepository.findAll();
        List<CoachDTO> coaches = new ArrayList<>();
        for(CoachDetails c : loadedCoaches) {
            CoachDTO confirmCoach = new CoachDTO();
            confirmCoach.setId(c.getCoach().getId());
            confirmCoach.setRegistrationNumber(c.getCoach().getRegistrationNumber());
            confirmCoach.setMark(c.getMark());
            confirmCoach.setModel(c.getModel());
            coaches.add(confirmCoach);
        }
        return coaches;
    }
}
