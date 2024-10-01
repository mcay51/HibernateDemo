package tr.com.mcay.hibernateoptimization.person.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tr.com.mcay.hibernateoptimization.person.dto.PersonDTO;
import tr.com.mcay.hibernateoptimization.person.dto.mapper.PersonMapper;
import tr.com.mcay.hibernateoptimization.person.model.Person;
import tr.com.mcay.hibernateoptimization.person.repository.PersonRepository;

@Service
public class PersonPropegationService {
    private PersonRepository personRepository;

    public PersonPropegationService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void savePersonWithRequired(PersonDTO person) {
        personRepository.save(PersonMapper.INSTANCE.personDTOToPerson(person));
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void savePersonWithRequiresNew(PersonDTO person) {
        personRepository.save(PersonMapper.INSTANCE.personDTOToPerson(person));
    }

    @Transactional(propagation = Propagation.NESTED)
    public void savePersonWithNested(PersonDTO person) {
        personRepository.save(PersonMapper.INSTANCE.personDTOToPerson(person));
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void savePersonWithSupports(PersonDTO person) {
        personRepository.save(PersonMapper.INSTANCE.personDTOToPerson(person));
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void savePersonWithNotSupported(PersonDTO person) {
        personRepository.save(PersonMapper.INSTANCE.personDTOToPerson(person));
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void savePersonWithMandatory(PersonDTO person) {
        personRepository.save(PersonMapper.INSTANCE.personDTOToPerson(person));
    }

    @Transactional(propagation = Propagation.NEVER)
    public void savePersonWithNever(PersonDTO person) {
        personRepository.save(PersonMapper.INSTANCE.personDTOToPerson(person));
    }
}
