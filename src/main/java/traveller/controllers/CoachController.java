package traveller.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import traveller.dtos.CoachDTO;
import traveller.dtos.UserDTO;
import traveller.services.CoachService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/coach")
public class CoachController {

    @Autowired
    CoachService coachService;

    @GetMapping("/add")
    public String addCoach(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser, Model model) {

        if(loggedUser == null) {
            return "redirect:/home";
        }
        model.addAttribute("coachForm", new CoachDTO());
        return "coach";
    }
    @PostMapping("/add")
    public String addCoach(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUSer,
            @ModelAttribute("coachForm") @Valid CoachDTO form, BindingResult result, HttpSession session) {

        if(loggedUSer == null) {
            return "redirect:/home";
        }
        if(result.hasErrors()) {
            return "coach";
        }
        boolean existedRegisterNumber = coachService.checkRegistrationNumber(form.getRegistrationNumber());
        if(existedRegisterNumber) {
            result.rejectValue("registrationNumber", "errors.invalid", "Ten numer rejestracyjny już jest w bazie");
            return "coach";
        }
        coachService.addCoach(form);
        return "redirect:/home";
    }
}
