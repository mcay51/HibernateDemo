package tr.com.mcay.hibernateoptimization.person.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.mcay.hibernateoptimization.person.dto.PersonDto;
import tr.com.mcay.hibernateoptimization.person.model.Person;
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
    public List<PersonDto> findAllPersonWithAddessJoinFetch() {
       return  personService.findAllWithAddressesJoinFetch();
    }

    @GetMapping("/find-all-person-lazy-address")
    public List<PersonDto> findAllPersonWithAddessLazy() {
        return  personService.findAllWithAddressesLazy();
    }
}
