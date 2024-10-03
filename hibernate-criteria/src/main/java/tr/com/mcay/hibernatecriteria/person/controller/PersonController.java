package tr.com.mcay.hibernatecriteria.person.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.mcay.hibernatecriteria.person.dto.PersonDTO;
import tr.com.mcay.hibernatecriteria.person.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<PersonDTO> getAllPersons() {
        return personService.findAll();
    }

    @GetMapping("/search")
    public ResponseEntity<List<PersonDTO>>  findPersonsWithJobTitleAndName(
            @RequestParam(required = false) String jobTitle,
            @RequestParam(required = false) String name) {
        List<PersonDTO> persons = personService.findPersonsWithJobTitleAndName(jobTitle, name);
        for (PersonDTO person : persons) {
            System.out.println("PERSON: "+person.getId());
        }
        return ResponseEntity.ok(persons);
    }
}
