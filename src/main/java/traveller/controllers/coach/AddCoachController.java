package traveller.controllers.coach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import traveller.dtos.CoachDTO;
import traveller.services.CoachService;
import javax.validation.Valid;

@Controller
@RequestMapping("/add-coach")
public class AddCoachController {

    @Autowired
    CoachService coachService;

    @GetMapping
    public String addCoach(Model model) {

        model.addAttribute("coachForm", new CoachDTO());
        return "add-coach";
    }
    @PostMapping
    public String addCoach(@ModelAttribute("coachForm") @Valid CoachDTO form, BindingResult result) {

        if(result.hasErrors()) {
            return "add-coach";
        }
        boolean existedRegisterNumber = coachService.checkRegistrationNumber(form.getRegistrationNumber());
        if(existedRegisterNumber) {
            result.rejectValue("registrationNumber", "errors.invalid", "Ten numer rejestracyjny już jest w bazie");
            return "add-coach";
        }
        coachService.addCoach(form);
        return "redirect:/";
    }
}
