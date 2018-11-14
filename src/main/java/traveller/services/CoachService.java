package traveller.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveller.dtos.CoachDTO;
import traveller.model.Coach;
import traveller.model.CoachDetails;
import traveller.repositories.CoachDetailsRepository;
import traveller.repositories.CoachRepository;

@Service
public class CoachService {

    @Autowired
    CoachRepository coachRepository;
    @Autowired
    CoachDetailsRepository coachDetailsRepository;

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
