package traveller.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveller.dtos.CustomerDTO;
import traveller.model.Customer;
import traveller.model.CustomerDetails;
import traveller.repositories.CustomerDetailsRepository;
import traveller.repositories.CustomerRepoistory;

@Service
public class CustomerService {

    @Autowired
    CustomerRepoistory customerRepoistory;
    @Autowired
    CustomerDetailsRepository customerDetailsRepository;
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
}
