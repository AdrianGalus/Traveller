package traveller.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import traveller.dtos.CoachDTO;
import traveller.dtos.TourDTO;
import traveller.dtos.UserDTO;
import traveller.model.Coach;
import traveller.repositories.CoachRepository;
import traveller.services.ConfirmTourService;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/confirm-tour")
public class ConfirmTourController {

    @Autowired
    ConfirmTourService confirmTourService;
    @Autowired
    CoachRepository coachRepository;

    @PostMapping
    public String confirmTour(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser,
                              @ModelAttribute("selectCoach") CoachDTO form, BindingResult result,
                              @RequestParam("tourFormId") String tourFormId, HttpSession session, Model model) {

        if(loggedUser == null) {
            return "redirect:/home";
        }
        TourDTO firstStepForm = (TourDTO) session.getAttribute(tourFormId);
        if(firstStepForm == null) {
            return "redirect:/home";
        }
        if(result.hasErrors()) {
            model.addAttribute("tourForm", firstStepForm);
            model.addAttribute("tourFormId", tourFormId);
            return "confirm-tour";
        }

        firstStepForm.setCoachId(form.getId());
        confirmTourService.confirmTour(firstStepForm);
        session.removeAttribute(tourFormId);
        return "redirect:/home";
    }
}
