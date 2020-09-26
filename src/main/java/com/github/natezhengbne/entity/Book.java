package com.github.natezhengbne.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

@Data
@Entity
public class Book extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer id;

    @Column(length = 100, nullable = false)
    public String title;

    @ManyToOne()
    @JoinColumn(name = "author_id") //
    public Author author;

}
