package traveller.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import traveller.dtos.UserDTO;
import traveller.services.CustomerService;

@Controller
@RequestMapping("/show-all-customers")
public class ShowAllCustomersController {

    @Autowired
    CustomerService showAllCustomersService;

    @GetMapping
    public String showAllCustomers(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser,
                                 Model model) {

        if(loggedUser == null) {
            return "redirect:/home";
        }
        model.addAttribute("allCustomers", showAllCustomersService.showAllCustomers());
        return "all-customers";
    }
}
