package traveller.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import traveller.dtos.TourDTO;
import traveller.dtos.UserDTO;
import traveller.services.CoachService;
import traveller.services.TourService;

import java.util.List;

@Controller
@RequestMapping("/delete-coach")
public class DeleteCoachController {

    @Autowired
    CoachService coachService;
    @Autowired
    TourService tourService;

    @GetMapping("/{id}")
    public String deleteCoach(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser, Model model,
                              @PathVariable("id") Long id) {

        if(loggedUser == null) {
            return "redirect:/home";
        }
        List<TourDTO> tours = tourService.findAllToursByCoachId(id);
        if(tours.size() > 0) {
            model.addAttribute("error", "Ten autobus ma zaplanowane wycieczki");
            return "warnings";
        }
        model.addAttribute("id", id);
        model.addAttribute("type", "coach");
        return "confirm-delete";
    }
    @GetMapping("/confirm/{id}")
    public String confirmDeleteCoach(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser,
                                     @PathVariable("id") Long id) {

        if(loggedUser == null) {
            return "redirect:/home";
        }
        coachService.deleteCoach(id);
        return "redirect:/home";
    }
}

