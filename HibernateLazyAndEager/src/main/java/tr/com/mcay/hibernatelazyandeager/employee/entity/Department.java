package tr.com.mcay.hibernatelazyandeager.employee.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import tr.com.mcay.hibernatelazyandeager.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Department extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();

}
