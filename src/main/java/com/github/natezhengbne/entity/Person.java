package com.github.natezhengbne.entity;

import com.github.natezhengbne.Status;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
public class Person {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private LocalDate birth;
    private Status status;

}
