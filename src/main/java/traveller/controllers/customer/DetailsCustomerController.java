package traveller.controllers.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import traveller.dtos.CustomerDTO;
import traveller.services.CustomerService;

@Controller
@RequestMapping("/details-customer")
public class DetailsCustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/{id}")
    public String findDetails(Model model, @PathVariable Long id) {

        CustomerDTO customerDTO = customerService.findDetails(id);
        model.addAttribute("customerDTO", customerDTO);
        return "customer-details";
    }
}
