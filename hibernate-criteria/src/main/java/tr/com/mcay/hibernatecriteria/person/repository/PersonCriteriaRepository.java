package tr.com.mcay.hibernatecriteria.person.repository;

import tr.com.mcay.hibernatecriteria.person.model.Person;

import java.util.List;

public interface PersonCriteriaRepository {
   List<Person> findPersonsWithJobTitleAndName(String jobTitle, String name);

}
