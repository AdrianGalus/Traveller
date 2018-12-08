package traveller.controllers.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import traveller.dtos.UserDTO;
import traveller.services.CustomerService;

@Controller
@RequestMapping("/find-customer")
public class FindCustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/all")
    public String findAllCustomers(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser,
                                   Model model) {

        if(loggedUser == null) {
            return "redirect:/home";
        }
        model.addAttribute("allCustomers", customerService.findAllCustomers());
        return "all-customers";
    }
}
