package traveller.controllers.coach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import traveller.dtos.CoachDTO;
import traveller.dtos.DriverDTO;
import traveller.dtos.UserDTO;
import traveller.services.CoachService;
import traveller.services.DriverService;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/edit-coach")
public class EditCoachController {

    @Autowired
    CoachService coachService;
    @Autowired
    DriverService driverService;

    @ModelAttribute("drivers")
    public List<DriverDTO> drivers() {

        return driverService.findAllDrivers();
    }
    @GetMapping("/{id}")
    public String editCoach(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser, Model model,
                            @PathVariable("id") Long id) {

        if(loggedUser == null) {
            return "redirect:/home";
        }
        model.addAttribute("coachForm", coachService.findDetails(id));
        return "edit-coach";
    }
    @PostMapping("/{id}")
    public String confirmEditCoach(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser,
                   @ModelAttribute("coachForm") @Valid CoachDTO form, BindingResult result) {

        if(loggedUser == null) {
            return "redirect:/home";
        }
        if(result.hasErrors()) {
            return "edit-coach";
        }
        if(checkRegistrationNumber(form)) {
            result.rejectValue("registrationNumber", "errors.invalid", "Ten numer rejestracyjny już jest w bazie");
            return "edit-coach";
        }
        coachService.editCoach(form);
        return "redirect:/home";
    }
    private boolean checkRegistrationNumber(CoachDTO form) {

        boolean existedRegistrationNumber = coachService.checkRegistrationNumber(form.getRegistrationNumber());
        String registrationNumberByCoachId = coachService.findRegistrationNumberByCoachId(form.getId());
        if(existedRegistrationNumber && !registrationNumberByCoachId.equals(form.getRegistrationNumber())) {
            return true;
        }
        return false;
    }
}
