package tr.com.mcay.hibernateoptimization.person.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.mcay.hibernateoptimization.person.dto.PersonDTO;
import tr.com.mcay.hibernateoptimization.person.service.PersonServiceLazyInitialization;
@RestController
@RequestMapping("/api")
public class PersonControllerLazyInitialization {

    private final PersonServiceLazyInitialization personService;

    public PersonControllerLazyInitialization(PersonServiceLazyInitialization personService) {
        this.personService = personService;
    }

    @GetMapping("/persons/{id}/addresses")
    public ResponseEntity<PersonDTO> getProjectWithAddresses(@PathVariable Long id) {
        PersonDTO personDTO = personService.findPersonWithAddressesLazy(id);
        return ResponseEntity.ok(personDTO);
    }
    @GetMapping("/persons/{id}/notransaddresses")
    public ResponseEntity<PersonDTO> getPersonWithoutTransaction(@PathVariable Long id) {
        PersonDTO personDTO = personService.findPersonWithoutTransaction(id);
        return ResponseEntity.ok(personDTO);
    }

}
