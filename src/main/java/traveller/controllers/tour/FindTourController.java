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
@RequestMapping("/find-tour")
public class FindTourController {

    @Autowired
    private TourService tourService;

    @GetMapping("/all")
    public String findAllTours(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser, Model model) {

        if(loggedUser == null) {
            return "redirect:/";
        }
        model.addAttribute("allTours", tourService.findAllTours());
        return "all-tours";
    }
    @GetMapping("/{dto}/{id}")
    public String findAllToursByDtoId(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser,
                                      Model model, @PathVariable String dto, @PathVariable Long id) {

        if(loggedUser == null) {
            return "redirect:/";
        }
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
