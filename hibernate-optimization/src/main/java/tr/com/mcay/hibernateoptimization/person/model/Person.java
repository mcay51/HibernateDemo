package tr.com.mcay.hibernateoptimization.person.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import tr.com.mcay.hibernateoptimization.address.dto.AddressDTO;
import tr.com.mcay.hibernateoptimization.address.dto.mapper.AddressMapper;
import tr.com.mcay.hibernateoptimization.address.model.Address;
import tr.com.mcay.hibernateoptimization.job.model.Job;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
@Getter
@Setter
@BatchSize(size = 10) //her seferinde 10 adres yükleyecek şekilde ayarlanır
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    @JsonManagedReference // Ana referans
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference // Ana referans
    private List<Job> jobs = new ArrayList<>();

}

