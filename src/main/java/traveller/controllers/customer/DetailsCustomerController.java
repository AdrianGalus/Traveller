package traveller.controllers.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import traveller.dtos.CustomerDTO;
import traveller.dtos.UserDTO;
import traveller.services.CustomerService;

@Controller
@RequestMapping("/details-customer")
public class DetailsCustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/{id}")
    public String findDetails(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser, Model model,
                              @PathVariable Long id) {

        if(loggedUser == null) {
            return "redirect:/home";
        }
        CustomerDTO customerDTO = customerService.findDetails(id);
        model.addAttribute("customerDTO", customerDTO);
        return "customer-details";
    }
}
