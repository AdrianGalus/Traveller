package traveller.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import traveller.dtos.*;
import traveller.services.TourService;
import traveller.services.CustomerService;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/tour")
public class TourController {

    @Autowired
    TourService tourService;
    @Autowired
    private CustomerService customerService;

    @ModelAttribute("customers")
    public List<CustomerDTO> customers() {

        return customerService.findAllCustomers();
    }
    @GetMapping("/check/{id}")
    public String checkTour(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser, Model model,
                            @PathVariable(value = "id") Long id) {

        if(loggedUser == null) {
            return "redirect:/home";
        }
        if(id == 0) {
            model.addAttribute("tourForm", new TourDTO());
        }
        else {
            model.addAttribute("tourForm", tourService.findDetails(id));
        }
        return "check-tour";
    }
    @PostMapping("/check/{id}")
    public String checkTour(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser, Model model,
                        @ModelAttribute("tourForm") @Valid TourDTO form, BindingResult result, HttpSession session,
                        @PathVariable(value = "id", required = false) Long id) {

        if(loggedUser == null) {
            return "redirect:/home";
        }
        if(result.hasErrors()) {
            return "check-tour";
        }
        if(form.getDepartureTime().isAfter(form.getArrivalTime())) {
            result.rejectValue("arrivalTime", "errors.invalid", "Data powrotu nie może być wcześniejsza od daty wyjazdu");
            return "check-tour";
        }
        List<CoachDTO> coaches = tourService.findAvailableCoaches();
        if(coaches == null ||coaches.size() < 1) {
            return "no-coach";
        }
        List<DriverDTO> drivers = tourService.findAvailableDrivers();
        if(drivers == null || drivers.size() < 1) {
            return "no-drivers";
        }
        model.addAttribute("confirmedTour", form);
        model.addAttribute("availableCoaches", coaches);
        model.addAttribute("availableDrivers", drivers);
        model.addAttribute("tourFormId", "tourForm" + System.identityHashCode(form));
        session.setAttribute("tourForm" + System.identityHashCode(form), form);
        return "confirm-tour";
    }
    @PostMapping("/confirm")
    public String confirmTour(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser,
                              @ModelAttribute("confirmedTour") TourDTO form, BindingResult result,
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
        firstStepForm.setCoachId(form.getCoachId());
        if(firstStepForm.getId() == null) {
            tourService.addTour(firstStepForm);
        }
        else {
            tourService.editTour(firstStepForm);
        }
        session.removeAttribute(tourFormId);
        return "redirect:/home";
    }
}
