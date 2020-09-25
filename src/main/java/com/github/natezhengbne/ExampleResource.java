package com.github.natezhengbne;

import com.github.natezhengbne.entity.Person;
import com.github.natezhengbne.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Slf4j
@Path("/hello")
public class ExampleResource {

    @Inject
    PersonRepository personRepository;
    @Inject
    Jsonb jsonb;

    @Logged
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        throw new RuntimeException("1");
//        return "123";
    }

}