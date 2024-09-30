package tr.com.mcay.hibernateoptimization.person.dto;

import lombok.Getter;
import lombok.Setter;
import tr.com.mcay.hibernateoptimization.address.dto.AddressDTO;
import tr.com.mcay.hibernateoptimization.address.dto.mapper.AddressMapper;
import tr.com.mcay.hibernateoptimization.address.model.Address;
import tr.com.mcay.hibernateoptimization.job.dto.JobDTO;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class PersonDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 2375175832496864118L;
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Address> addresses = new ArrayList<>();
    private List<JobDTO> jobs = new ArrayList<>();

}
