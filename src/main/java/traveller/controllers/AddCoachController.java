package traveller.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import traveller.dtos.CoachDTO;
import traveller.dtos.UserDTO;
import traveller.services.AddCoachService;
import javax.validation.Valid;

@Controller
@RequestMapping("/addcoach")
public class AddCoachController {

    @Autowired
    AddCoachService addCoachService;

    @GetMapping
    public String addCoach(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser, Model model) {

        if(loggedUser == null) {
            return "redirect:/home";
        }
        model.addAttribute("coachForm", new CoachDTO());
        return "addcoach";
    }
    @PostMapping
    public String addCoach(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUSer,
                                @ModelAttribute("coachForm") @Valid CoachDTO form, BindingResult result) {

        if(loggedUSer == null) {
            return "redirect:/home";
        }
        if(result.hasErrors()) {
            return "addcoach";
        }
        boolean existedRegisterNumber = addCoachService.checkRegistrationNumber(form.getRegistrationNumber());
        if(existedRegisterNumber) {
            result.rejectValue("registrationNumber", "errors.invalid", "Ten numer rejestracyjny już jest w bazie");
            return "addcoach";
        }
        addCoachService.addCoach(form);
        return "redirect:/home";
    }
}