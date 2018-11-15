package traveller.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import traveller.dtos.CoachDTO;
import traveller.dtos.TourDTO;
import traveller.dtos.UserDTO;
import traveller.services.CheckTourService;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/check-tour")
public class CheckTourController {

    @Autowired
    CheckTourService checkTourService;

    @GetMapping
    public String checkTour(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser, Model model) {

        if(loggedUser == null) {
            return "redirect:/home";
        }
        model.addAttribute("tourForm", new TourDTO());
        return "check-tour";
    }
    @PostMapping
    public String checkTour(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser,
                @ModelAttribute("tourForm") @Valid TourDTO form, BindingResult result, Model model, HttpSession session) {

        if(loggedUser == null) {
            return "redirect:/home";
        }
        if(result.hasErrors()) {
            return "check-tour";
        }
        List<CoachDTO> coaches = checkTourService.loadAvailableCoaches();
        if(coaches == null ||coaches.size() < 1) {
            return "no-coach";
        }
        else {
            model.addAttribute("selectCoach", form);
            model.addAttribute("availableCoaches", coaches);
            model.addAttribute("tourFormId", "tourForm" + System.identityHashCode(form));
            session.setAttribute("tourForm" + System.identityHashCode(form), form);
            return "confirm-tour";
        }
    }
}
