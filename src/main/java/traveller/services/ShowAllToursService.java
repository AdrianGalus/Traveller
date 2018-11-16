package traveller.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveller.dtos.TourDTO;
import traveller.model.TourDetails;
import traveller.repositories.TourDetailsRepository;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShowAllToursService {

    @Autowired
    TourDetailsRepository tourDetailsRepository;

    public List<TourDTO> showAllTours() {
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
}
