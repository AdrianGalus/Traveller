package traveller.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import traveller.dtos.DriverDTO;
import traveller.dtos.UserDTO;
import traveller.services.AddDriverService;
import javax.validation.Valid;

@Controller
@RequestMapping("/adddriver")
public class AddDriverController {

    @Autowired
    AddDriverService addDriverService;

    @GetMapping("/add")
    public String addCoach(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser, Model model) {

        if(loggedUser == null) {
            return "redirect:/home";
        }
        model.addAttribute("driverForm", new DriverDTO());
        return "adddriver";
    }
    @PostMapping("/add")
    public String addCoach(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUSer,
                                @ModelAttribute("driverForm") @Valid DriverDTO form, BindingResult result) {

        if(loggedUSer == null) {
            return "redirect:/home";
        }
        if(result.hasErrors()) {
            return "adddriver";
        }
        addDriverService.addDriver(form);
        return "redirect:/home";
    }
}
