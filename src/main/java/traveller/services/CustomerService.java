package traveller.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import traveller.dtos.CustomerDTO;
import traveller.model.Customer;
import traveller.model.CustomerDetails;
import traveller.repositories.CustomerDetailsRepository;
import traveller.repositories.CustomerRepoistory;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerService {

    @Autowired
    CustomerDetailsRepository customerDetailsRepository;
    @Autowired
    CustomerRepoistory customerRepoistory;

    public void addCustomer(CustomerDTO form) {

        Customer customer = new Customer();
        customer.setFistName(form.getFirstName());
        customer.setLastName(form.getLastName());
        customerRepoistory.save(customer);
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setCustomer(customer);
        customerDetails.setPhone(form.getPhone());
        customerDetails.setEmail(form.getPhone());
        customerDetailsRepository.save(customerDetails);
    }
    public List<CustomerDTO> findAllCustomers() {
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
