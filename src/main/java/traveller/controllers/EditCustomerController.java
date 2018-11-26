package traveller.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import traveller.dtos.CustomerDTO;
import traveller.dtos.UserDTO;
import traveller.services.CustomerService;
import javax.validation.Valid;

@Controller
@RequestMapping("/edit-customer")
public class EditCustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/{id}")
    public String editCustomer(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser, Model model,
                               @PathVariable("id") Long id) {

        if(loggedUser == null) {
            return "redirect:/home";
        }
        model.addAttribute("customerForm", customerService.findDetails(id));
        return "edit-customer";
    }
    @PostMapping("/{id}")
    public String confirmEditCustomer(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser,
                                      @ModelAttribute("customerForm") @Valid CustomerDTO form, BindingResult result) {

        if(loggedUser == null) {
            return "redirect:/home";
        }
        if(result.hasErrors()) {
            return "edit-customer";
        }

        if(checkPhone(form)) {
            result.rejectValue("phone", "errors.invalid", "Ten numer telefonu już jest w bazie");
            return "edit-customer";
        }
        if(checkEmail(form)) {
            result.rejectValue("email", "errors.invalid", "Ten email już jest w bazie");
            return "edit-customer";
        }
        customerService.editCustomer(form);
        return "redirect:/home";
    }
    private boolean checkPhone(CustomerDTO form) {

        boolean existedPhone = customerService.checkPhone(form.getPhone());
        String phoneByCustomerId = customerService.findPhoneByCustomerId(form.getId());
        if(existedPhone && !phoneByCustomerId.equals(form.getPhone())) {
            return true;
        }
        return false;
    }
    private boolean checkEmail(CustomerDTO form) {

        boolean existedEmail = customerService.checkEmail(form.getEmail());
        String emailByCustomerId = customerService.findEmailByCustomerId(form.getId());
        if(existedEmail && !emailByCustomerId.equals(form.getEmail())) {
            return true;
        }
        return false;
    }
}
