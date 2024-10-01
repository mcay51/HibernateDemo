package tr.com.mcay.hibernateoptimization.job.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class UpdateEmailRequest {
    private String newEmail;
    private List<Long> ids;


}

