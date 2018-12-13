package traveller.controllers.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import traveller.dtos.CustomerDTO;
import traveller.services.CustomerService;
import javax.validation.Valid;

@Controller
@RequestMapping("/add-customer")
public class AddCustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public String addCustomer(Model model) {

        model.addAttribute("customerForm", new CustomerDTO());
        return "add-customer";
    }
    @PostMapping
    public String addCustomer(@ModelAttribute("customerForm") @Valid CustomerDTO form, BindingResult result) {

        if(result.hasErrors()) {
            return "add-customer";
        }
        boolean existedPhone = customerService.checkPhone(form.getPhone());
        if(existedPhone) {
            result.rejectValue("phone", "errors.invalid", "Ten numer telefonu już jest w bazie!");
            return "add-customer";
        }
        boolean existedEmail = customerService.checkEmail(form.getEmail());
        if(existedEmail) {
            result.rejectValue("email", "errors.invalid", "Ten adres email już jest w bazie!");
            return "add-customer";
        }
        customerService.addCustomer(form);
        return "redirect:/";
    }
}
