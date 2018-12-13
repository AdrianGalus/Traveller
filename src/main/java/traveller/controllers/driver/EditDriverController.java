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
@RequestMapping("/edit-driver")
public class EditDriverController {

    @Autowired
    DriverService driverService;
    @Autowired
    CoachService coachService;

    @GetMapping("/{id}")
    public String editDriver(Model model, @PathVariable("id") Long id) {

        model.addAttribute("availableCoaches", coachService.findAvailableCoaches());
        model.addAttribute("driverForm", driverService.findDetails(id));
        return "edit-driver";
    }
    @PostMapping("/{id}")
    public String confirmEditDriver(Model model, @ModelAttribute("driverForm") @Valid DriverDTO form,
                                    BindingResult result, @PathVariable("id") Long id) {

        if(result.hasErrors()) {
            return "edit-driver";
        }
        if(checkPhone(form)) {
            result.rejectValue("phone", "errors.invalid", "Ten numer telefonu już jest w bazie");
            return "edit-driver";
        }
        if(checkEmail(form)) {
            result.rejectValue("email", "errors.invalid", "Ten email już jest w bazie");
            return "edit-driver";
        }
        driverService.editDriver(form);
        return "redirect:/";
    }
    private boolean checkPhone(DriverDTO form) {

        boolean existedPhone = driverService.checkPhone(form.getPhone());
        String phoneByDriverId = driverService.findPhoneByDriverId(form.getId());
        if(existedPhone && !phoneByDriverId.equals(form.getPhone())) {
            return true;
        }
        return false;
    }
    private boolean checkEmail(DriverDTO form) {

        boolean existedEmail = driverService.checkEmail(form.getEmail());
        String emailByDriverId = driverService.findEmailByDriverId(form.getId());
        if(existedEmail && !emailByDriverId.equals(form.getEmail())) {
            return true;
        }
        return false;
    }
}
