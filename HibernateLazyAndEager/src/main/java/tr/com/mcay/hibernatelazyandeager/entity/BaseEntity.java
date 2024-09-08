package tr.com.mcay.hibernatelazyandeager.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private boolean deleted = false;

    @Column(nullable = false)
    private Long creationTime;

    private Long updateTime;

    private Long deletionTime;

}





