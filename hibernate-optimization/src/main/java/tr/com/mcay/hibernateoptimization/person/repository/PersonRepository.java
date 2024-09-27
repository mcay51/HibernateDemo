package tr.com.mcay.hibernateoptimization.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.mcay.hibernateoptimization.person.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
