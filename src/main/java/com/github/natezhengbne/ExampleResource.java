package com.github.natezhengbne;

import com.github.natezhengbne.repository.PersonRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {

    @Inject
    PersonRepository personRepository;

    @GET
    public long count(){
        return personRepository.count();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

}