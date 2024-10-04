package tr.com.mcay.hibernatecriteria;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class HibernateCriteriaApplication {
    public static void main(String[] args) {
        SpringApplication.run(HibernateCriteriaApplication.class, args);
    }

}
