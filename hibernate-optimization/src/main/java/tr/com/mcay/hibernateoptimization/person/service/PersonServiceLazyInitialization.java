package tr.com.mcay.hibernateoptimization.person.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import tr.com.mcay.hibernateoptimization.address.dto.AddressDTO;
import tr.com.mcay.hibernateoptimization.address.dto.mapper.AddressMapper;
import tr.com.mcay.hibernateoptimization.person.dto.PersonDTO;
import tr.com.mcay.hibernateoptimization.person.dto.mapper.PersonMapper;
import tr.com.mcay.hibernateoptimization.person.model.Person;
import tr.com.mcay.hibernateoptimization.person.repository.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceLazyInitialization {
    private final PersonRepository personRepository;

    public PersonServiceLazyInitialization(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // LazyInitializationException alacağımız yöntem
    //@Transactional
    public PersonDTO findPersonWithAddressesLazy(Long personId) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new EntityNotFoundException("Person not found"));
        // addresses'e erişmeye çalışıyoruz, ancak LAZY olduğu için session kapalı olduğunda hata oluşur
        List<AddressDTO> addresses = person.getAddresses().stream()
                .map(address -> AddressMapper.INSTANCE.addressToAddressDTO(address))
                .collect(Collectors.toList());

        PersonDTO personDTO = PersonMapper.INSTANCE.personToPersonDTO(person);
        personDTO.setAddresses(addresses);

        return personDTO;
    }
    public PersonDTO findPersonWithoutTransaction(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Person not found"));

        // Transaction yok ama lazy load çalışacak
        List<AddressDTO> addresses = person.getAddresses().stream()
                .map(address -> AddressMapper.INSTANCE.addressToAddressDTO(address))
                .collect(Collectors.toList());

        PersonDTO personDTO = PersonMapper.INSTANCE.personToPersonDTO(person);
        personDTO.setAddresses(addresses);

        return personDTO;
    }
}
