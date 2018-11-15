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
        List<CoachDTO> coachesDTO = new ArrayList<>();
        for(CoachDetails c : loadedCoaches) {
            CoachDTO coachDTO = new CoachDTO();
            coachDTO.setId(c.getCoach().getId());
            coachDTO.setRegistrationNumber(c.getCoach().getRegistrationNumber());
            coachDTO.setMark(c.getMark());
            coachDTO.setModel(c.getModel());
            coachesDTO.add(coachDTO);
        }
        return coachesDTO;
    }
}
