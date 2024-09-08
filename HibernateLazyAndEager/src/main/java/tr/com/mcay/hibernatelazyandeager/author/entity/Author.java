package tr.com.mcay.hibernatelazyandeager.author.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import tr.com.mcay.hibernatelazyandeager.entity.BaseEntity;

import java.util.List;

@Entity
@Getter
@Setter
public class Author extends BaseEntity {
    @Column
    private String name;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Book> books;

    // Getters and Setters
}
