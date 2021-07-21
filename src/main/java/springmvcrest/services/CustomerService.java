package springmvcrest.services;

import springmvcrest.api.v1.model.CategoryDTO;
import springmvcrest.api.v1.model.CustomerDTO;
import springmvcrest.domain.Customer;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomerById(Long id);
    CustomerDTO createNewCustomer(CustomerDTO customerDTO);
    CustomerDTO saveCustomerByDTO(Long id, CustomerDTO customerDTO);
}
