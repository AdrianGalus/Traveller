package traveller.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import traveller.dtos.TourDTO;
import traveller.model.Tour;
import traveller.model.TourDetails;
import traveller.repositories.*;

@Service
@Transactional
public class ConfirmTourService {

    @Autowired
    TourRepository tourRepository;
    @Autowired
    TourDetailsRepository tourDetailsRepository;
    @Autowired
    CoachRepository coachRepository;
    @Autowired
    CustomerRepoistory customerRepoistory;
    @Autowired
    DriverRepository driverRepository;

    public void confirmTour(TourDTO confirmedTour) {

        Tour newTour = new Tour();
        newTour.setDestination(confirmedTour.getDestination());
        newTour.setDepartureDate(confirmedTour.getDepartureTime());
        newTour.setArrivalDate(confirmedTour.getArrivalTime());
        newTour.setCoach(coachRepository.findOne(confirmedTour.getCoachId()));
        newTour.setCustomer(customerRepoistory.findOne(confirmedTour.getCustomerId()));
        tourRepository.save(newTour);
        TourDetails newTourDetails = new TourDetails();
        newTourDetails.setDistance(confirmedTour.getDistance());
        newTourDetails.setPrice(confirmedTour.getPrice());
        newTourDetails.setTour(newTour);
        tourDetailsRepository.save(newTourDetails);
    }
}
