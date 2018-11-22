package traveller.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import traveller.dtos.CustomerDTO;
import traveller.model.Customer;
import traveller.model.CustomerDetails;
import traveller.model.Tour;
import traveller.repositories.CustomerDetailsRepository;
import traveller.repositories.CustomerRepository;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerService {

    @Autowired
    CustomerDetailsRepository customerDetailsRepository;
    @Autowired
    CustomerRepository customerRepository;

    public CustomerDTO findDetails(Long id) {

        CustomerDTO customerDTO = new CustomerDTO();
        Customer loadedCustomer = customerRepository.findOne(id);
        CustomerDetails loadedCustomerDetails = customerDetailsRepository.findByCustomerId(id);
        customerDTO.setId(loadedCustomerDetails.getCustomer().getId());
        customerDTO.setName(loadedCustomer.getName());
        customerDTO.setFirstName(loadedCustomer.getFirstName());
        customerDTO.setLastName(loadedCustomer.getLastName());
        customerDTO.setPhone(loadedCustomerDetails.getPhone());
        customerDTO.setEmail(loadedCustomerDetails.getEmail());
        List<Long> toursId = new ArrayList<>();
        for(Tour t : loadedCustomer.getTours()) {
            toursId.add(t.getId());
        }
        customerDTO.setToursId(toursId);
        return customerDTO;
    }
    public boolean checkPhone(String phone) {

        Boolean check = customerDetailsRepository.isPhoneUsed(phone);
        return check != null ? check : false;
    }
    public boolean checkEmail(String email) {

        Boolean check = customerDetailsRepository.isEmailUsed(email);
        return check != null ? check : false;
    }
    public void addCustomer(CustomerDTO form) {

        Customer customer = new Customer();
        customer.setName(form.getName());
        customer.setFirstName(form.getFirstName());
        customer.setLastName(form.getLastName());
        customerRepository.save(customer);
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setCustomer(customer);
        customerDetails.setPhone(form.getPhone());
        customerDetails.setEmail(form.getEmail());
        customerDetailsRepository.save(customerDetails);
    }
    public List<CustomerDTO> findAllCustomers() {

        List<CustomerDetails> loadedCustomers = customerDetailsRepository.findAll();
        return createCustomerDtoList(loadedCustomers);
    }
    private List<CustomerDTO> createCustomerDtoList(List<CustomerDetails> loadedCustomers) {

        List<CustomerDTO> coachesDTO = new ArrayList<>();
        for(CustomerDetails c : loadedCustomers) {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setId(c.getCustomer().getId());
            customerDTO.setName(c.getCustomer().getName());
            customerDTO.setFirstName(c.getCustomer().getFirstName());
            customerDTO.setLastName(c.getCustomer().getLastName());
            customerDTO.setPhone(c.getPhone());
            customerDTO.setEmail(c.getEmail());
            coachesDTO.add(customerDTO);
        }
        return coachesDTO;
    }
}
