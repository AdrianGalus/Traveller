package traveller.controllers.coach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import traveller.dtos.UserDTO;
import traveller.services.CoachService;

@Controller
@RequestMapping("/find-coach")
public class FindCoachController {

    @Autowired
    CoachService coachService;

    @GetMapping("/all")
    public String findAllCoaches(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser,
                                 Model model) {

        if(loggedUser == null) {
            return "redirect:/";
        }
        model.addAttribute("allCoaches", coachService.findAllCoaches());
        return "all-coaches";
    }
}
