package tr.com.mcay.hibernateoptimization.job.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import tr.com.mcay.hibernateoptimization.person.model.Person;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
public class JobDTO implements Serializable {
private static final long serialVersionUID =  -6708961357224810723L;
    private Long id;
    private String jobTitle;
    private String companyName;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal salary;
    private Person person;

}
