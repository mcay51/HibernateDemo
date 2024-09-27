package tr.com.mcay.hibernateoptimization.person.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.mcay.hibernateoptimization.person.service.PersonService;

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
}
