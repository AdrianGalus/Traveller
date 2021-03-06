package traveller.controllers.tour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import traveller.dtos.UserDTO;
import traveller.services.TourService;

@Controller
@RequestMapping("/delete-tour")
public class DeleteTourController {

    @Autowired
    TourService tourService;

    @GetMapping("/{id}")
    public String deleteTour(Model model, @PathVariable("id") Long id) {

        model.addAttribute("id", id);
        model.addAttribute("type", "tour");
        return "confirm-delete";
    }
    @GetMapping("/confirm/{id}")
    public String confirmDeleteTour(@PathVariable("id") Long id) {

        tourService.deleteTour(id);
        return "redirect:/";
    }
}
