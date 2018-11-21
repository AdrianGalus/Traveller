package traveller.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import traveller.dtos.CoachDTO;
import traveller.dtos.TourDTO;
import traveller.model.*;
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
    CustomerRepository customerRepository;
    @Autowired
    CoachService coachService;

    public TourDTO findDetails(Long id) {

        TourDTO tourDTO = new TourDTO();
        Tour loadedTour = tourRepository.findOne(id);
        TourDetails loadedTourDetails = tourDetailsRepository.findByTourId(id);
        tourDTO.setId(loadedTourDetails.getTour().getId());
        tourDTO.setDestination(loadedTour.getDestination());
        tourDTO.setDepartureTime(loadedTour.getDepartureDate());
        tourDTO.setArrivalTime(loadedTour.getArrivalDate());
        tourDTO.setDistance(loadedTourDetails.getDistance());
        tourDTO.setPrice(loadedTourDetails.getPrice());
        Customer customer = loadedTour.getCustomer();
        if(customer != null) {
            tourDTO.setCustomerId(customer.getId());
        }
        Coach coach = loadedTour.getCoach();
        if(coach != null) {
            tourDTO.setCoachId(coach.getId());
        }
        List<Long> driversId = new ArrayList<>();
        for(Driver d : loadedTour.getDrivers()) {
            driversId.add(d.getId());
        }
        tourDTO.setDriversId(driversId);
        return tourDTO;
    }
    public List<TourDTO> findAllTours() {

        List<TourDetails> loadedTours = tourDetailsRepository.findAll();
        return createTourDtoList(loadedTours);
    }
    public List<TourDTO> findAllToursByCoachId(Long id) {

        List<TourDetails> loadedToursDetails = tourDetailsRepository.findAllByCoachId(id);
        return createTourDtoList(loadedToursDetails);
    }
    public List<TourDTO> findAllToursByCustomerId(Long id) {

        List<TourDetails> loadedToursDetails = tourDetailsRepository.findAllByCustomerId(id);
        return createTourDtoList(loadedToursDetails);
    }
    public List<CoachDTO> findAvailableCoaches() {

        return coachService.findAvailableCoaches();
    }
    public void confirmTour(TourDTO confirmedTour) {

        Tour newTour = new Tour();
        newTour.setDestination(confirmedTour.getDestination());
        newTour.setDepartureDate(confirmedTour.getDepartureTime());
        newTour.setArrivalDate(confirmedTour.getArrivalTime());
        newTour.setCoach(coachRepository.findOne(confirmedTour.getCoachId()));
        newTour.setCustomer(customerRepository.findOne(confirmedTour.getCustomerId()));
        tourRepository.save(newTour);
        TourDetails newTourDetails = new TourDetails();
        newTourDetails.setDistance(confirmedTour.getDistance());
        newTourDetails.setPrice(confirmedTour.getPrice());
        newTourDetails.setTour(newTour);
        tourDetailsRepository.save(newTourDetails);
    }
    private List<TourDTO> createTourDtoList(List<TourDetails> loadedToursDetails) {

        List<TourDTO> toursDTO = new ArrayList<>();
        for(TourDetails td : loadedToursDetails) {
            TourDTO tourDTO = new TourDTO();
            tourDTO.setId(td.getTour().getId());
            tourDTO.setDestination(td.getTour().getDestination());
            tourDTO.setDepartureTime(td.getTour().getDepartureDate());
            tourDTO.setArrivalTime(td.getTour().getArrivalDate());
            tourDTO.setDistance(td.getDistance());
            tourDTO.setPrice(td.getPrice());
            tourDTO.setCoachId(td.getTour().getCoach().getId());
            tourDTO.setCustomerId(td.getTour().getCustomer().getId());
            List<Long> driversId = new ArrayList<>();
            for(Driver d : td.getTour().getDrivers()) {
                driversId.add(d.getId());
            }
            tourDTO.setDriversId(driversId);
            toursDTO.add(tourDTO);
        }
        return toursDTO;
    }
}
