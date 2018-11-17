package traveller.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import traveller.dtos.UserDTO;
import traveller.services.CoachService;

@Controller
@RequestMapping("/show-all-coaches")
public class ShowAllCoachesController {

    @Autowired
    CoachService coachService;

    @GetMapping
    public String showAllCoaches(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser,
                                Model model) {

        if(loggedUser == null) {
            return "redirect:/home";
        }
        model.addAttribute("allCoaches", coachService.showAllCoaches());
        return "all-coaches";
    }
}
