package traveller.controllers.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import traveller.dtos.DriverDTO;
import traveller.dtos.UserDTO;
import traveller.services.CoachService;
import traveller.services.DriverService;
import javax.validation.Valid;

@Controller
@RequestMapping("/add-driver")
public class AddDriverController {

    @Autowired
    DriverService driverService;
    @Autowired
    CoachService coachService;

    @GetMapping
    public String addCoach(Model model) {

        model.addAttribute("availableCoaches", coachService.findAvailableCoaches());
        model.addAttribute("driverForm", new DriverDTO());
        return "add-driver";
    }
    @PostMapping
    public String addCoach(@ModelAttribute("driverForm") @Valid DriverDTO form, BindingResult result) {

        if(result.hasErrors()) {
            return "add-driver";
        }
        boolean existedPhone = driverService.checkPhone(form.getPhone());
        if(existedPhone) {
            result.rejectValue("phone", "errors.invalid", "Ten numer telefonu już jest w bazie!");
            return "add-driver";
        }
        boolean existedEmail = driverService.checkEmail(form.getEmail());
        if(existedEmail) {
            result.rejectValue("email", "errors.invalid", "Ten adres email jest już w bazie!");
            return "add-driver";
        }
        driverService.addDriver(form);
        return "redirect:/";
    }
}
