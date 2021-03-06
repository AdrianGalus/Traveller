package traveller.controllers.tour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import traveller.services.TourService;

@Controller
@RequestMapping("/show-tour")
public class ShowTourController {

    @Autowired
    private TourService tourService;

    @GetMapping("/all")
    public String showAllTours(Model model) {

        model.addAttribute("allTours", tourService.findAllTours());
        return "all-tours";
    }
    @GetMapping("/{dto}/{id}")
    public String showAllToursByDtoId(Model model, @PathVariable String dto, @PathVariable Long id) {

        switch(dto) {
            case "coachDTO":
                model.addAttribute("allTours", tourService.findAllToursByCoachId(id));
                break;
            case "driverDTO":
                model.addAttribute("allTours", tourService.findAllToursByDriverId(id));
                break;
            case "customerDTO":
                model.addAttribute("allTours", tourService.findAllToursByCustomerId(id));
                break;
        }
        return "all-tours";
    }
}
