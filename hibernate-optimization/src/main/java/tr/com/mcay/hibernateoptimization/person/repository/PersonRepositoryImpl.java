package tr.com.mcay.hibernateoptimization.person.repository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import tr.com.mcay.hibernateoptimization.address.model.Address;
import tr.com.mcay.hibernateoptimization.person.model.Person;

import java.util.List;

@Repository
public abstract class PersonRepositoryImpl implements PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // Criteria API method to join Person and Address
    public List<Person> findPersonsWithAddresses() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> query = cb.createQuery(Person.class);
        Root<Person> personRoot = query.from(Person.class);

        // Joining with Address
        Join<Person, Address> addressJoin = personRoot.join("person_id");

        // Selecting persons with their addresses
        query.select(personRoot).distinct(true);

        return entityManager.createQuery(query).getResultList();
    }
}
