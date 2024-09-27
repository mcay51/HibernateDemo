package tr.com.mcay.hibernateoptimization;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import tr.com.mcay.hibernateoptimization.address.model.Address;
import tr.com.mcay.hibernateoptimization.person.controller.PersonController;
import tr.com.mcay.hibernateoptimization.person.dto.PersonDTO;
import tr.com.mcay.hibernateoptimization.person.model.Person;
import tr.com.mcay.hibernateoptimization.person.repository.PersonRepository;
import tr.com.mcay.hibernateoptimization.person.service.PersonService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)

public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    @Test
    public void testCreatePerson() throws Exception {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setFirstName("Ahmet");
        personDTO.setLastName("Yılmaz");
        personDTO.setEmail("ahmet.yilmaz@example.com");

        when(personService.createPerson(any(PersonDTO.class))).thenReturn(personDTO);

        mockMvc.perform(post("/api/persons")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(personDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName").value("Ahmet"));
    }
    @Test
    public void testGetPersonWithAddressesEager() throws Exception {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setFirstName("Ahmet");
        personDTO.setLastName("Yılmaz");
        personDTO.setEmail("ahmet.yilmaz@example.com");

        when(personService.getPersonByIdEager(1L)).thenReturn(personDTO);

        mockMvc.perform(get("/api/persons/eager/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Ahmet"));
    }

    @Test
    public void testGetPersonWithAddressesLazy() throws Exception {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setFirstName("Ahmet");
        personDTO.setLastName("Yılmaz");
        personDTO.setEmail("ahmet.yilmaz@example.com");

        when(personService.getPersonByIdLazy(1L)).thenReturn(personDTO);

        mockMvc.perform(get("/api/persons/lazy/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Ahmet"));
    }

}

