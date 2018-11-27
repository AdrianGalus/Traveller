package traveller.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import traveller.dtos.CoachDTO;
import traveller.dtos.DriverDTO;
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
    @Autowired
    DriverService driverService;

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
    public List<TourDTO> findAllToursByDriverId(Long id) {

        List<TourDetails> loadedToursDetails = tourDetailsRepository.findAllByDriverId(id);
        return createTourDtoList(loadedToursDetails);
    }
    public List<CoachDTO> findAvailableCoaches() {

        return coachService.findAvailableCoaches();
    }
    public List<DriverDTO> findAvailableDrivers() {

        return driverService.findAvailableDrivers();
    }
    public void addTour(TourDTO confirmedTour) {

        Tour newTour = new Tour();
        saveTourInDB(newTour, confirmedTour);
        TourDetails newTourDetails = new TourDetails();
        saveTourDetailsInDB(newTourDetails, newTour, confirmedTour);
    }
    public void editTour(TourDTO confirmedTour) {

        Tour editedTour = tourRepository.findOne(confirmedTour.getId());
        saveTourInDB(editedTour, confirmedTour);
        TourDetails editedTourDetails = tourDetailsRepository.findByTourId(confirmedTour.getId());
        saveTourDetailsInDB(editedTourDetails, editedTour, confirmedTour);
    }
    public void deleteTour(Long id) {

        tourDetailsRepository.delete(tourDetailsRepository.findByTourId(id));
        tourRepository.delete(id);
    }
    private void saveTourInDB(Tour tour, TourDTO confirmedTour) {

        tour.setDestination(confirmedTour.getDestination());
        tour.setDepartureDate(confirmedTour.getDepartureTime());
        tour.setArrivalDate(confirmedTour.getArrivalTime());
        tour.setCustomer(customerRepository.findOne(confirmedTour.getCustomerId()));
        tour.setCoach(coachRepository.findOne(confirmedTour.getCoachId()));
        //TODO set drivers
        tourRepository.save(tour);
    }
    private void saveTourDetailsInDB(TourDetails tourDetails, Tour tour, TourDTO confirmedTour) {

        tourDetails.setDistance(confirmedTour.getDistance());
        tourDetails.setPrice(confirmedTour.getPrice());
        tourDetails.setTour(tour);
        tourDetailsRepository.save(tourDetails);
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
