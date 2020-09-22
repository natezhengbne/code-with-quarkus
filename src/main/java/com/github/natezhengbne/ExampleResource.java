package com.github.natezhengbne;

import com.github.natezhengbne.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Slf4j
@Path("/hello")
public class ExampleResource {

    @Inject
    PersonRepository personRepository;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        if(personRepository==null){
            log.error("personRepository is null");
            return "-1";
        }else{
            log.info("http request ---> hello");
        }
        return personRepository.findById(0L).getName();
    }

}