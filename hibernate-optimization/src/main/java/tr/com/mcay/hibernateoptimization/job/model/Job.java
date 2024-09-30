package tr.com.mcay.hibernateoptimization.job.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import tr.com.mcay.hibernateoptimization.person.model.Person;
import java.math.BigDecimal;

import java.time.LocalDate;

@Entity
@Table(name = "job")
@Setter
@Getter
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "salary")
    private BigDecimal salary;

    @ManyToOne(fetch = FetchType.LAZY)  // İlişki türü (ManyToOne)
    @JoinColumn(name = "person_id", nullable = false)  // Yabancı anahtar
    @JsonBackReference
    private Person person;  // Person ile olan ilişkiyi temsil eden alan
}