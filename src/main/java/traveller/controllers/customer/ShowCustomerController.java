package traveller.controllers.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import traveller.services.CustomerService;

@Controller
@RequestMapping("/show-customer")
public class ShowCustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/all")
    public String showAllCustomers(Model model) {

        model.addAttribute("allCustomers", customerService.findAllCustomers());
        return "all-customers";
    }
}
