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
    public String findPhoneByCustomerId(Long id) {

        return customerDetailsRepository.findPhoneByCustomerId(id);
    }
    public boolean checkEmail(String email) {

        Boolean check = customerDetailsRepository.isEmailUsed(email);
        return check != null ? check : false;
    }
    public String findEmailByCustomerId(Long id) {

        return customerDetailsRepository.findEmailByCustomerId(id);
    }
    public void addCustomer(CustomerDTO form) {

        Customer customer = new Customer();
        saveCustomerInDB(customer, form);
        CustomerDetails customerDetails = new CustomerDetails();
        saveCustomerDetailsInDB(customerDetails, customer, form);
    }
    public void editCustomer(CustomerDTO form) {

        Customer customer = customerRepository.findOne(form.getId());
        saveCustomerInDB(customer, form);
        CustomerDetails customerDetails = customerDetailsRepository.findByCustomerId(form.getId());
        saveCustomerDetailsInDB(customerDetails, customer, form);
    }
    public void deleteCustomer(Long id) {

        customerDetailsRepository.delete(customerDetailsRepository.findByCustomerId(id));
        customerRepository.delete(id);
    }
    public List<CustomerDTO> findAllCustomers() {

        List<CustomerDetails> loadedCustomers = customerDetailsRepository.findAll();
        return createCustomerDtoList(loadedCustomers);
    }
    private void saveCustomerInDB(Customer customer, CustomerDTO confirmedCustomer) {

        customer.setName(confirmedCustomer.getName());
        customer.setFirstName(confirmedCustomer.getFirstName());
        customer.setLastName(confirmedCustomer.getLastName());
        customerRepository.save(customer);
    }
    private void saveCustomerDetailsInDB(CustomerDetails customerDetails, Customer customer, CustomerDTO confirmedCustomer) {

        customerDetails.setPhone(confirmedCustomer.getPhone());
        customerDetails.setEmail(confirmedCustomer.getEmail());
        customerDetails.setCustomer(customer);
        customerDetailsRepository.save(customerDetails);
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
