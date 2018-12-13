package traveller.controllers.tour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import traveller.dtos.TourDTO;
import traveller.services.TourService;

@Controller
@RequestMapping("/details-tour")
public class DetailsTourController {

    @Autowired
    TourService tourService;

    @GetMapping("/{id}")
    public String findDetails(Model model, @PathVariable Long id) {

        TourDTO tourDTO = tourService.findDetails(id);
        model.addAttribute("tourDTO", tourDTO);
        return "tour-details";
    }
}
