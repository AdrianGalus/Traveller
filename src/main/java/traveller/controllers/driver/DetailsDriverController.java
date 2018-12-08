package traveller.controllers.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import traveller.dtos.DriverDTO;
import traveller.dtos.UserDTO;
import traveller.services.DriverService;

@Controller
@RequestMapping("/details-driver")
public class DetailsDriverController {

    @Autowired
    DriverService driverService;

    @GetMapping("/{id}")
    public String findDetails(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser, Model model,
                              @PathVariable Long id) {

        if(loggedUser == null) {
            return "redirect:/";
        }
        DriverDTO driverDTO = driverService.findDetails(id);
        model.addAttribute("driverDTO", driverDTO);
        return "driver-details";
    }
}
