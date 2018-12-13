package traveller.controllers.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import traveller.services.DriverService;

@Controller
@RequestMapping("/delete-driver")
public class DeleteDriverController {

    @Autowired
    DriverService driverService;

    @GetMapping("/{id}")
    public String deleteDriver(Model model, @PathVariable("id") Long id) {

        model.addAttribute("id", id);
        model.addAttribute("type", "driver");
        return "confirm-delete";
    }
    @GetMapping("/confirm/{id}")
    public String confirmDeleteCustomer(@PathVariable("id") Long id) {

        driverService.deleteDriver(id);
        return "redirect:/";
    }
}
