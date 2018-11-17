package traveller.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import traveller.dtos.UserDTO;
import traveller.services.DriverService;

@Controller
@RequestMapping("/find-driver")
public class FindDriverController {

    @Autowired
    DriverService driverService;

    @GetMapping("/all")
    public String findAllDrivers(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser,
                                 Model model) {

        if(loggedUser == null) {
            return "redirect:/home";
        }
        model.addAttribute("allDrivers", driverService.findAllDrivers());
        return "all-drivers";
    }
}
