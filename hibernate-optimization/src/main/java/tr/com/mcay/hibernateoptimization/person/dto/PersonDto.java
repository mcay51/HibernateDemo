package tr.com.mcay.hibernateoptimization.person.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import tr.com.mcay.hibernateoptimization.address.model.Address;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class PersonDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Address> addresses = new ArrayList<>();
}
