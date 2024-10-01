package tr.com.mcay.hibernateoptimization.person.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.mcay.hibernateoptimization.person.dto.PersonDTO;
import tr.com.mcay.hibernateoptimization.person.model.Person;
import tr.com.mcay.hibernateoptimization.person.service.PersonPropegationService;

@RestController
@RequestMapping("/api/persons")
public class PersonPropegationController {
    private final PersonPropegationService personService;

    public PersonPropegationController(PersonPropegationService personPropegationService) {
        this.personService = personPropegationService;
    }

    @PostMapping("/required")
    public ResponseEntity<Void> createWithRequired(@RequestBody PersonDTO person) {
        personService.savePersonWithRequired(person);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/requires-new")
    public ResponseEntity<Void> createWithRequiresNew(@RequestBody PersonDTO person) {
        personService.savePersonWithRequiresNew(person);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/nested")
    public ResponseEntity<Void> createWithNested(@RequestBody PersonDTO person) {
        personService.savePersonWithNested(person);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/supports")
    public ResponseEntity<Void> createWithSupports(@RequestBody PersonDTO person) {
        personService.savePersonWithSupports(person);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/not-supported")
    public ResponseEntity<Void> createWithNotSupported(@RequestBody PersonDTO person) {
        personService.savePersonWithNotSupported(person);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/mandatory")
    public ResponseEntity<Void> createWithMandatory(@RequestBody PersonDTO person) {
        personService.savePersonWithMandatory(person);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/never")
    public ResponseEntity<Void> createWithNever(@RequestBody PersonDTO person) {
        personService.savePersonWithNever(person);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
