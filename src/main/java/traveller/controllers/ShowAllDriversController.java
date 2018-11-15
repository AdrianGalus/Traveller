package traveller.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import traveller.dtos.UserDTO;
import traveller.services.ShowAllDriversService;

@Controller
@RequestMapping("/show-all-drivers")
public class ShowAllDriversController {

    @Autowired
    ShowAllDriversService showAllDriversService;
    @GetMapping
    public String showAllCoaches(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser,
                                 Model model) {

        if(loggedUser == null) {
            return "redirect:/home";
        }
        model.addAttribute("allDrivers", showAllDriversService.showAllDrivers());
        return "all-drivers";
    }
}
