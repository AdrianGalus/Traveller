package traveller.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import traveller.dtos.CoachDTO;
import traveller.dtos.TourDTO;
import traveller.model.CoachDetails;
import traveller.model.Tour;
import traveller.model.TourDetails;
import traveller.repositories.*;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TourService {

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
    @Autowired
    CoachDetailsRepository coachDetailsRepository;

    public List<TourDTO> findAllTours() {
        List<TourDetails> loadedTours = tourDetailsRepository.findAll();
        List<TourDTO> toursDTO = new ArrayList<>();
        for(TourDetails d : loadedTours) {
            TourDTO tourDTO = new TourDTO();
            tourDTO.setId(d.getTour().getId());
            tourDTO.setDestination(d.getTour().getDestination());
            tourDTO.setDepartureTime(d.getTour().getDepartureDate());
            tourDTO.setArrivalTime(d.getTour().getArrivalDate());
            tourDTO.setCoachId(d.getTour().getCoach().getId());
            tourDTO.setDistance(d.getDistance());
            tourDTO.setPrice(d.getPrice());
            toursDTO.add(tourDTO);
        }
        return toursDTO;
    }
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
