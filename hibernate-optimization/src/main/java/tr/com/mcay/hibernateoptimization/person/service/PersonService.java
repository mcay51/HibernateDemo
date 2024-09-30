package tr.com.mcay.hibernateoptimization.person.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import tr.com.mcay.hibernateoptimization.address.dto.mapper.AddressMapper;
import tr.com.mcay.hibernateoptimization.address.model.Address;
import tr.com.mcay.hibernateoptimization.address.repository.AddressRepository;
import tr.com.mcay.hibernateoptimization.person.dto.PersonDTO;
import tr.com.mcay.hibernateoptimization.person.dto.mapper.PersonMapper;
import tr.com.mcay.hibernateoptimization.person.model.Person;
import tr.com.mcay.hibernateoptimization.person.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {


    private PersonRepository personRepository;


    private AddressRepository addressRepository;

    public PersonService(PersonRepository personRepository, AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }

    public void createPersonWithAddress() {
        Person person = new Person();
        person.setFirstName("Ahmet");
        person.setLastName("Yılmaz");
        person.setEmail("ahmet.yilmaz@example.com");

        Address address1 = new Address();
        address1.setStreet("İstiklal Caddesi No:10");
        address1.setCity("İstanbul");
        address1.setZipCode("34000");
        address1.setPerson(person);

        Address address2 = new Address();
        address2.setStreet("Atatürk Bulvarı No:15");
        address2.setCity("Ankara");
        address2.setZipCode("06000");
        address2.setPerson(person);

        person.getAddresses().add(address1);
        person.getAddresses().add(address2);

        personRepository.save(person);

    }
    public List<PersonDTO> findAllWithAddressesJoinFetch() {
        List<Person> persons = personRepository.findAllWithAddresses();
        return persons.stream()
                .map(PersonMapper.INSTANCE::personToPersonDTO)
                .collect(Collectors.toList());
    }
    public List<PersonDTO> findAllWithAddressesLazy() {
        List<Person> persons = personRepository.findAll();
        return persons.stream()
                .map(PersonMapper.INSTANCE::personToPersonDTO)
                .collect(Collectors.toList());
    }


    public PersonDTO createPerson(PersonDTO personDTO) {
        Person person = PersonMapper.INSTANCE.personDTOToPerson(personDTO);
        Person savedPerson = personRepository.save(person);
        return PersonMapper.INSTANCE.personToPersonDTO(savedPerson);
    }

    public PersonDTO getPersonByIdEager(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Person not found"));
        return PersonMapper.INSTANCE.personToPersonDTO(person);
    }

    public PersonDTO getPersonByIdLazy(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Person not found"));
        System.out.println("Bu noktada addresses henüz yüklenmemiştir.");
        return PersonMapper.INSTANCE.personToPersonDTO(person);
    }
}

