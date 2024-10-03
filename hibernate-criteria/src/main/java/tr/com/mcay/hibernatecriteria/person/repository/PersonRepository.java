package tr.com.mcay.hibernatecriteria.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.mcay.hibernatecriteria.person.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}