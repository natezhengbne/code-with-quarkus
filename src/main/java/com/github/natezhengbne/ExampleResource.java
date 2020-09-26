package com.github.natezhengbne;

import com.github.natezhengbne.entity.Person;
import com.github.natezhengbne.repository.PersonRepository;
import io.vertx.core.impl.BlockedThreadChecker;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Path("/hello")
public class ExampleResource {

    @Inject
    PersonRepository personRepository;
    @Inject
    Jsonb jsonb;
    @Inject
//    List<String> names;
    ProducerTest producerTest;


    @Logged
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
//        throw new RuntimeException("1");
//        log.info(names.toArray().toString());
        log.info(Arrays.toString(producerTest.names().toArray()));
        return "123";
    }

}