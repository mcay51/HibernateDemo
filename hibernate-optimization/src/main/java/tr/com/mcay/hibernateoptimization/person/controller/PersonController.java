package tr.com.mcay.hibernateoptimization.person.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.mcay.hibernateoptimization.person.dto.PersonDTO;
import tr.com.mcay.hibernateoptimization.person.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {
   private final PersonService personService;
   public PersonController(PersonService personService) {
       this.personService = personService;
   }
    @GetMapping("/add-sample-record")
    public String addSampleRecord() {
       personService.createPersonWithAddress();
        return "Örnek kayıtlar eklendi";
    }

    @GetMapping("/find-all-person-join-fetch-address")
    public ResponseEntity<List<PersonDTO>> findAllPersonWithAddessJoinFetch() {
       return  ResponseEntity.ok(personService.findAllWithAddressesJoinFetch());
    }

    @GetMapping("/find-all-person-lazy-address")
    public ResponseEntity<List<PersonDTO>> findAllPersonWithAddessLazy() {
        return ResponseEntity.ok(personService.findAllWithAddressesLazy());
    }

    @PostMapping("/persons")
    public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO personDTO) {
        PersonDTO createdPerson = personService.createPerson(personDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPerson);
    }

    @GetMapping("/persons/eager/{id}")
    public ResponseEntity<PersonDTO> getPersonWithAddressesEager(@PathVariable Long id) {
        PersonDTO personDTO = personService.getPersonByIdEager(id);
        return ResponseEntity.ok(personDTO);
    }

    @GetMapping("/persons/lazy/{id}")
    public ResponseEntity<PersonDTO> getPersonWithAddressesLazy(@PathVariable Long id) {
        PersonDTO personDTO = personService.getPersonByIdLazy(id);
        return ResponseEntity.ok(personDTO);
    }


}
