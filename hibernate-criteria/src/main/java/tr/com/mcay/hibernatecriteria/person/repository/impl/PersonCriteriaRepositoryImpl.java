package tr.com.mcay.hibernatecriteria.person.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;
import tr.com.mcay.hibernatecriteria.job.model.Job;
import tr.com.mcay.hibernatecriteria.person.model.Person;
import tr.com.mcay.hibernatecriteria.person.repository.PersonCriteriaRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonCriteriaRepositoryImpl implements PersonCriteriaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Person> findPersonsWithJobTitleAndName(String jobTitle, String name) {
        System.out.println("name "+name);
        System.out.println("jobTitle "+jobTitle);
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> query = cb.createQuery(Person.class);
        Root<Person> personRoot = query.from(Person.class);

        Join<Person, Job> jobJoin = personRoot.join("jobs", JoinType.INNER);

        List<Predicate> predicates = new ArrayList<>();
        if (jobTitle != null) {
            predicates.add(cb.equal(jobJoin.get("jobTitle"), jobTitle));
        }
        if (name != null) {
            predicates.add(cb.like(personRoot.get("firstName"), "%" + name + "%"));
        }

        query.select(personRoot)
                .where(cb.and(predicates.toArray(new Predicate[0])));

        return entityManager.createQuery(query).getResultList();
    }
}
