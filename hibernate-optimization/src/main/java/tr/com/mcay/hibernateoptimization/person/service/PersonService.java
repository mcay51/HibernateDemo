package tr.com.mcay.hibernateoptimization.person.service;

import org.springframework.stereotype.Service;
import tr.com.mcay.hibernateoptimization.address.model.Address;
import tr.com.mcay.hibernateoptimization.address.repository.AddressRepository;
import tr.com.mcay.hibernateoptimization.person.dto.PersonDto;
import tr.com.mcay.hibernateoptimization.person.model.Person;
import tr.com.mcay.hibernateoptimization.person.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

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
    public List<PersonDto> findAllWithAddressesJoinFetch() {
        return personConverter(personRepository.findAllWithAddresses());
    }
    public List<PersonDto> findAllWithAddressesLazy() {
        return personConverter(personRepository.findAll());
    }
    private List<PersonDto> personConverter(List<Person> persons){
        List<PersonDto> personDtoList = new ArrayList<>();
      for (Person person : persons) {
        PersonDto personDto = new PersonDto();
        personDto.setFirstName(person.getFirstName());
        personDto.setLastName(person.getLastName());
        personDto.setEmail(person.getEmail());
        personDto.setId(person.getId());
        //personDto.setAddresses(person.getAddresses());
        personDtoList.add(personDto);
      }
        return personDtoList;
    }
}

