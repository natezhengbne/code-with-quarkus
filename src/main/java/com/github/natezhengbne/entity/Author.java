package com.github.natezhengbne.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Author extends PanacheEntityBase {
    public String firstName;

    public String lastName;

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GenericGenerator(name = "native", strategy = "native")
//    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer id;

//    @OneToMany(
//            mappedBy = "author",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    public Set<Book> books;
}
