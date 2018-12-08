package traveller.controllers.coach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import traveller.dtos.CoachDTO;
import traveller.dtos.UserDTO;
import traveller.services.CoachService;

@Controller
@RequestMapping("/details-coach")
public class DetailsCoachController {

    @Autowired
    CoachService coachService;

    @GetMapping("/{id}")
    public String findDetails(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser, Model model,
                              @PathVariable Long id) {

        if(loggedUser == null) {
            return "redirect:/home";
        }
        CoachDTO coachDTO = coachService.findDetails(id);
        model.addAttribute("coachDTO", coachDTO);
        return "coach-details";
    }
}
