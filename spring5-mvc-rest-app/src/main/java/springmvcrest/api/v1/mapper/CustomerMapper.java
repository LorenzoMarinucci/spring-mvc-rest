package springmvcrest.api.v1.mapper;

import lorenzo.springframework.model.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import springmvcrest.domain.Customer;

@Mapper
public interface CustomerMapper {

    public CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO customerToCustomerDTO(Customer customer);
    Customer customerDTOToCustomer(CustomerDTO customerDTO);

}
