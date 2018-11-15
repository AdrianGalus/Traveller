package traveller.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import traveller.dtos.TourDTO;
import traveller.dtos.UserDTO;
import traveller.model.Coach;
import traveller.services.ConfirmTourService;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/confirm-tour")
public class ConfirmTourController {

    @Autowired
    ConfirmTourService confirmTourService;

    @PostMapping
    public String confirmTour(@SessionAttribute(value = "loggedUser", required = false)UserDTO loggedUser,
    @ModelAttribute("selectCoach") TourDTO form, @RequestParam("tourFormId") String tourFormId, HttpSession session) {

        if(loggedUser == null) {
            return "redirect:/home";
        }
        Coach coach = form.getCoach();
        if(coach == null) {
            return "redirect:/home";
        }
        TourDTO confirmedTour = (TourDTO)session.getAttribute(tourFormId);
        if(confirmedTour == null) {
            return "redirect:/home";
        }
        confirmedTour.setCoach(coach);
        confirmTourService.confirmTour(form);
        session.removeAttribute(tourFormId);
        return "redirect:/home";
    }
}
