package com.github.natezhengbne;

import io.quarkus.arc.DefaultBean;
import io.quarkus.runtime.StartupEvent;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.interceptor.InvocationContext;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Slf4j
public class ProducerTest {

    @Produces
    @DefaultBean
    List<String> names() {
        List<String> names = new ArrayList<>();
        names.add("Andy");
        names.add("Adalbert");
        names.add("Joachim");
        return names;
    }

    @Produces
    public ProducerTest producerTest(){
        return new ProducerTest();
    }

    void startup(@Observes StartupEvent event) {
        System.out.println("11111111111111111111111111111111111111111111111111111111111");
    }

    @PreDestroy
    void cleanup(InvocationContext ctx) {
        log.info("----> PreDestroy");
    }

    @PostConstruct
    void post(){
        log.info("----> PostConstruct");

    }
}
