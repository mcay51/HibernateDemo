package tr.com.mcay.hibernateoptimization.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tr.com.mcay.hibernateoptimization.person.model.Person;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("SELECT p FROM Person p JOIN FETCH p.addresses")
    List<Person> findAllWithAddresses();
}
