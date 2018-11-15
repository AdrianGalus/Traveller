package traveller.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveller.dtos.CustomerDTO;
import traveller.model.CustomerDetails;
import traveller.repositories.CustomerDetailsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowAllCustomersService {

    @Autowired
    CustomerDetailsRepository customerDetailsRepository;

    public List<CustomerDTO> showAllCustomers() {
        List<CustomerDetails> loadedCustomers = customerDetailsRepository.findAll();
        List<CustomerDTO> coachesDTO = new ArrayList<>();
        for(CustomerDetails c : loadedCustomers) {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setId(c.getCustomer().getId());
            customerDTO.setFirstName(c.getCustomer().getFistName());
            customerDTO.setLastName(c.getCustomer().getLastName());
            customerDTO.setPhone(c.getPhone());
            customerDTO.setEmail(c.getEmail());
            coachesDTO.add(customerDTO);
        }
        return coachesDTO;
    }
}
