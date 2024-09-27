package tr.com.mcay.hibernateoptimization.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.mcay.hibernateoptimization.address.model.Address;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
