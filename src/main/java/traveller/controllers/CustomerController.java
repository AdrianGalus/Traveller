package traveller.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import traveller.dtos.CustomerDTO;
import traveller.dtos.UserDTO;
import traveller.services.CustomerService;
import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public String addCustomer(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser, Model model) {

        if(loggedUser == null) {
            return "redirect:/home";
        }
        model.addAttribute("customerForm", new CustomerDTO());
        return "customer";
    }
    public String addCustomer(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser,
                              @ModelAttribute("coachForm") @Valid CustomerDTO form, BindingResult result) {
        if(loggedUser == null) {
            return "redirect:/home";
        }
        if(result.hasErrors()) {
            return "driver";
        }
        customerService.addCustomer(form);
        return "redirect:/home";
    }
}
