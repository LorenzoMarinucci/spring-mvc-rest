package springmvcrest.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springmvcrest.domain.Category;
import springmvcrest.domain.Customer;
import springmvcrest.domain.Vendor;
import springmvcrest.repositories.CategoryRepository;
import springmvcrest.repositories.CustomerRepository;
import springmvcrest.repositories.VendorRepository;

@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;
    private VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        loadCategories();
        log.debug("Categories loaded = " + categoryRepository.count());
        loadCustomers();
        log.debug("Customers loaded = " + customerRepository.count());
        loadVendors();
        log.debug("Vendors loaded = " + vendorRepository.count());
    }

    private void loadVendors() {
        Vendor john = new Vendor();
        john.setName("John");

        Vendor mark = new Vendor();
        mark.setName("Mark");

        Vendor michael = new Vendor();
        michael.setName("Michael");

        Vendor logan = new Vendor();
        logan.setName("Logan");

        vendorRepository.save(john);
        vendorRepository.save(mark);
        vendorRepository.save(michael);
        vendorRepository.save(logan);
    }

    private void loadCustomers() {
        Customer marcos = new Customer();
        marcos.setFirstName("Marcos");
        marcos.setLastName("Gutierrez");

        Customer agustin = new Customer();
        agustin.setFirstName("Agustin");
        agustin.setLastName("Fernandez");

        Customer matias = new Customer();
        matias.setFirstName("Matias");
        matias.setLastName("Lopez");

        Customer sebastian = new Customer();
        sebastian.setFirstName("Sebastian");
        sebastian.setLastName("Marquez");

        customerRepository.save(marcos);
        customerRepository.save(agustin);
        customerRepository.save(matias);
        customerRepository.save(sebastian);
    }

    private void loadCategories() {
        Category fruits = new Category();
        fruits.setName("Fuits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);
    }
}
