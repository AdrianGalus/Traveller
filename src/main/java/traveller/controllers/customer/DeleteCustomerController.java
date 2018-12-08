package traveller.controllers.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import traveller.dtos.TourDTO;
import traveller.dtos.UserDTO;
import traveller.services.CustomerService;
import traveller.services.TourService;
import java.util.List;

@Controller
@RequestMapping("/delete-customer")
public class DeleteCustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    TourService tourService;

    @GetMapping("/{id}")
    public String deleteCustomer(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser, Model model,
                                 @PathVariable("id") Long id) {

        if(loggedUser == null) {
            return "redirect:/";
        }
        List<TourDTO> tours = tourService.findAllToursByCustomerId(id);
        if(tours.size() > 0) {
            model.addAttribute("error", "Ten klient ma zamówioną wycieczkę");
            return "warnings";
        }
        model.addAttribute("id", id);
        model.addAttribute("type", "customer");
        return "confirm-delete";
    }
    @GetMapping("/confirm/{id}")
    public String confirmDeleteCustomer(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser,
                                        @PathVariable("id") Long id) {

        if(loggedUser == null) {
            return "redirect:/";
        }
        customerService.deleteCustomer(id);
        return "redirect:/";
    }
}
