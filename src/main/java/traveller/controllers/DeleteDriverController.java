package traveller.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import traveller.dtos.UserDTO;
import traveller.services.DriverService;

@Controller
@RequestMapping("/delete-driver")
public class DeleteDriverController {

    @Autowired
    DriverService driverService;

    @GetMapping("/{id}")
    public String deleteDriver(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser, Model model,
                               @PathVariable("id") Long id) {

        if(loggedUser == null) {
            return "redirect:/home";
        }
        model.addAttribute("id", id);
        model.addAttribute("type", "driver");
        return "confirm-delete";
    }
    @GetMapping("/confirm/{id}")
    public String confirmDeleteCustomer(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser,
                                        @PathVariable("id") Long id) {

        if(loggedUser == null) {
            return "redirect:/home";
        }
        driverService.deleteDriver(id);
        return "redirect:/home";
    }
}
