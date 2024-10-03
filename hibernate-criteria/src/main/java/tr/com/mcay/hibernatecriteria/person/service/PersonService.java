package tr.com.mcay.hibernatecriteria.person.service;

import org.springframework.stereotype.Service;
import tr.com.mcay.hibernatecriteria.person.dto.PersonDTO;
import tr.com.mcay.hibernatecriteria.person.dto.mapper.PersonMapper;
import tr.com.mcay.hibernatecriteria.person.repository.PersonCriteriaRepository;
import tr.com.mcay.hibernatecriteria.person.repository.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonCriteriaRepository personCriteriaRepository;

    public PersonService(PersonRepository personRepository, PersonCriteriaRepository personCriteriaRepository) {
        this.personRepository = personRepository;
        this.personCriteriaRepository = personCriteriaRepository;
    }

    public List<PersonDTO> findAll() {
        return personRepository.findAll().stream()
                .map(PersonMapper.INSTANCE::personToPersonDTO)
                .collect(Collectors.toList());
    }

    public List<PersonDTO> findPersonsWithJobTitleAndName(String jobTitle, String name) {
        return personCriteriaRepository.findPersonsWithJobTitleAndName(jobTitle, name).stream()
                .map(PersonMapper.INSTANCE::personToPersonDTO)
                .collect(Collectors.toList());
    }
}
