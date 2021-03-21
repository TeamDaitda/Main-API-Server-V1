package com.daitda.backend;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.daitda.backend.service.*.get*(..))")
    public void loggerBefore() {
        System.out.println("get method started.");
    }

    @After("execution(* com.daitda.backend.service.*.get*(..))")
    public void loggerAfter() {
        System.out.println("get method ended");
    }

    @Around("execution(* com.daitda.backend.controller.UserController.*(..))")
    public Object loggerAround(ProceedingJoinPoint pjp) throws Throwable {
        long beforeTimeMillis = System.currentTimeMillis();
        System.out.println("[UserController] start Time : "
                +pjp.getSignature().getDeclaringTypeName() + "."
                +pjp.getSignature().getName());
        Object result = pjp.proceed();

        long afterTimeMillis = System.currentTimeMillis() - beforeTimeMillis;
        System.out.println("[UserController] start Ended: " + afterTimeMillis + "mil sec"
                +pjp.getSignature().getDeclaringTypeName() + "."
                +pjp.getSignature().getName());

        return result;

    }
}
