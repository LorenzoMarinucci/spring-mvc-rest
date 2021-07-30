package springmvcrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springmvcrest.domain.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {

}
