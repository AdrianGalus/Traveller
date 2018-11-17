package traveller.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import traveller.dtos.UserDTO;
import traveller.services.TourService;

@Controller
@RequestMapping("/find-tour")
public class FindTourController {

    @Autowired
    private TourService tourService;

    @GetMapping("/all")
    public String findAllTours(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser,
                               Model model) {

        if(loggedUser == null) {
            return "redirect:/home";
        }
        model.addAttribute("allTours", tourService.findAllTours());
        return "all-tours";
    }
}
