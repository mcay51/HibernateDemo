package tr.com.mcay.hibernatelazyandeager.author.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import tr.com.mcay.hibernatelazyandeager.entity.BaseEntity;

@Entity
@Getter
@Setter
public class Book extends BaseEntity {

    @Column
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    // Getters and Setters
}

