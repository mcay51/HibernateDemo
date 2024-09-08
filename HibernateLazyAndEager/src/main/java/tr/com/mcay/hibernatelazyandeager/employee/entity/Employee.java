package tr.com.mcay.hibernatelazyandeager.employee.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import tr.com.mcay.hibernatelazyandeager.entity.BaseEntity;

@Entity
@Getter
@Setter
public class Employee extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

}
