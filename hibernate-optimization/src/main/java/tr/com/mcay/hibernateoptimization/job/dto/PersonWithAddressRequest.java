package tr.com.mcay.hibernateoptimization.job.dto;

import lombok.Getter;
import lombok.Setter;
import tr.com.mcay.hibernateoptimization.address.dto.AddressDTO;
import tr.com.mcay.hibernateoptimization.person.dto.PersonDTO;
@Getter
@Setter
public class PersonWithAddressRequest {
    private PersonDTO person;
    private AddressDTO address;
}
