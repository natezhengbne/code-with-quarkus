package com.github.natezhengbne.repository;

import com.github.natezhengbne.entity.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {

    public Person findByName(String name){
        return find("name", name).firstResult();
    }

    public void deleteStefs(){
        delete("name", "Stef");
    }
}
