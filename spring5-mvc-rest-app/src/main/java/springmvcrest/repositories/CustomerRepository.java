package springmvcrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springmvcrest.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
