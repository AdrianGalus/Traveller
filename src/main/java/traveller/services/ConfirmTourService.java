package traveller.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveller.dtos.TourDTO;
import traveller.model.Tour;
import traveller.model.TourDetails;
import traveller.repositories.TourDetailsRepository;
import traveller.repositories.TourRepository;

@Service
public class ConfirmTourService {

    @Autowired
    TourRepository tourRepository;
    @Autowired
    TourDetailsRepository tourDetailsRepository;

    public void confirmTour(TourDTO confirmedTour) {

        Tour newTour = new Tour();
        newTour.setDestination(confirmedTour.getDestination());
        newTour.setDepartureDate(confirmedTour.getDepartureTime());
        newTour.setArrivalDate(confirmedTour.getArrivalTime());
        newTour.setCoach(confirmedTour.getCoach());
        newTour.setCustomer(confirmedTour.getCustomer());
        newTour.setDrivers(confirmedTour.getDrivers());
        tourRepository.save(newTour);
        TourDetails newTourDetails = new TourDetails();
        newTourDetails.setDistance(confirmedTour.getDistance());
        newTourDetails.setPrice(confirmedTour.getPrice());
        tourDetailsRepository.save(newTourDetails);
    }
}
