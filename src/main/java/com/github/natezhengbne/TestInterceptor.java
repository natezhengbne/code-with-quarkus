package com.github.natezhengbne;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.interceptor.*;
import javax.ws.rs.Produces;

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



    @AroundConstruct
    void aroundConstruct(InvocationContext ctx){
        log.info("----> AroundConstruct");
    }

    @AroundTimeout
    public void timeout(){
        log.info("----> AroundTimeout");

    }
}
