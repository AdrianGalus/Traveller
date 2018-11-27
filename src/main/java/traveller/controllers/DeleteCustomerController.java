package traveller.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import traveller.dtos.UserDTO;
import traveller.services.CustomerService;

@Controller
@RequestMapping("/delete-customer")
public class DeleteCustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/{id}")
    public String deleteCustomer(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser, Model model,
                                 @PathVariable("id") Long id) {

        if(loggedUser == null) {
            return "redirect:/home";
        }
        model.addAttribute("id", id);
        model.addAttribute("type", "customer");
        return "confirm-delete";
    }
    @GetMapping("/confirm/{id}")
    public String confirmDeleteCustomer(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser,
                                        @PathVariable("id") Long id) {

        if(loggedUser == null) {
            return "redirect:/home";
        }
        customerService.deleteCustomer(id);
        return "redirect:/home";
    }
}
