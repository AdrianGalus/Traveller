package traveller.controllers.driver;

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
@RequestMapping("/show-driver")
public class ShowDriverController {

    @Autowired
    DriverService driverService;

    @GetMapping("/all")
    public String showAllDrivers(Model model) {

        model.addAttribute("allDrivers", driverService.findAllDrivers());
        return "all-drivers";
    }
    @GetMapping("/{dto}/{id}")
    public String showAllDriversByDtoId(Model model, @PathVariable String dto, @PathVariable Long id) {

        switch(dto) {
            case "tourDTO":
                model.addAttribute("allDrivers", driverService.findAllDriversByTourId(id));
                break;
            case "coachDTO":
                model.addAttribute("allDrivers", driverService.findAllDriversByCoachId(id));
                break;
        }
        return "all-drivers";
    }
}
