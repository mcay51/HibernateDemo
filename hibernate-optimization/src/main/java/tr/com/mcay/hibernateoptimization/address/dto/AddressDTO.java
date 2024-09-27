package tr.com.mcay.hibernateoptimization.address.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import tr.com.mcay.hibernateoptimization.person.model.Person;
@Getter
@Setter
public class AddressDTO {
    private Long id;
    private String street;
    private String city;
    private String zipCode;
    private Person person;
}
