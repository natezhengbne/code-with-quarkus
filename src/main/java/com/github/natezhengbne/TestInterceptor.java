package com.github.natezhengbne;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.interceptor.*;

@ApplicationScoped
@Logged
@Slf4j
@Interceptor
//@Priority(Interceptor.Priority.APPLICATION+200)
public class TestInterceptor {
    @AroundInvoke
    public Object logInvocation(InvocationContext ctx) throws Exception {

        log.info("----> logInvocation");
        try{
            Object result = ctx.proceed();
            return  result;
        }catch (Exception e){
            log.info("----> Exception");
            throw e;
        }

//        Object result = ctx.proceed();
//        return  result;
    }

    @PreDestroy
    void cleanup(InvocationContext ctx) {
        log.info("----> PreDestroy");
    }

    @PostConstruct
    public void post(){
        log.info("----> PostConstruct");

    }

    @AroundConstruct
    public void aroundConstruct(InvocationContext ctx){
        log.info("----> AroundConstruct");
    }

    @AroundTimeout
    public void timeout(){
        log.info("----> AroundTimeout");

    }
}
