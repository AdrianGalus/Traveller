package traveller.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import traveller.dtos.CoachDTO;
import traveller.dtos.CustomerDTO;
import traveller.dtos.TourDTO;
import traveller.dtos.UserDTO;
import traveller.services.TourService;
import traveller.services.CustomerService;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/add-tour")
public class AddTourController {

    @Autowired
    TourService tourService;
    @Autowired
    private CustomerService customerService;

    @ModelAttribute("customers")
    public List<CustomerDTO> customers() {

        return customerService.findAllCustomers();
    }
    @GetMapping("/check")
    public String checkTour(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser, Model model) {

        if(loggedUser == null) {
            return "redirect:/home";
        }
        model.addAttribute("tourForm", new TourDTO());
        return "check-tour";
    }
    @PostMapping("/check")
    public String checkTour(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser,
                @ModelAttribute("tourForm") @Valid TourDTO form, BindingResult result, Model model, HttpSession session) {

        if(loggedUser == null) {
            return "redirect:/home";
        }
        if(result.hasErrors()) {
            return "check-tour";
        }
        List<CoachDTO> coaches = tourService.findAvailableCoaches();
        if(coaches == null ||coaches.size() < 1) {
            return "no-coach";
        }
        if(form.getDepartureTime().isAfter(form.getArrivalTime())) {
            result.rejectValue("arrivalTime", "errors.invalid", "Data powrotu nie może być wcześniejsza niż data wyjazdu!");
            return "check-tour";
        }
        else {
            model.addAttribute("selectCoach", new CoachDTO());
            model.addAttribute("availableCoaches", coaches);
            model.addAttribute("tourFormId", "tourForm" + System.identityHashCode(form));
            session.setAttribute("tourForm" + System.identityHashCode(form), form);
            return "confirm-tour";
        }
    }
    @PostMapping("/confirm")
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
        tourService.confirmTour(firstStepForm);
        session.removeAttribute(tourFormId);
        return "redirect:/home";
    }
}
