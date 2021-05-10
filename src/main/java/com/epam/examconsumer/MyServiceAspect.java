package com.epam.examconsumer;

import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
@Aspect
public class MyServiceAspect {


    @Around("@annotation(Benchmark)")
    public Object doWithBenchMark(ProceedingJoinPoint pjp) throws Throwable {
        String methodName = pjp.getSignature().getName();
        System.out.println("****BENCHARK STARTED FOR method "+ methodName);
        long start = System.nanoTime();
        Object retVal = pjp.proceed();
        long end = System.nanoTime();
        System.out.println(end-start);
        System.out.println("****BENCHARK finished FOR method "+ methodName);
        return retVal;
    }


   /* @SneakyThrows
    @Around("@annotation(Deprecated) && execution(* com.epam..*.*(..))")
    public Object doBeforeDeprecatedMethods(ProceedingJoinPoint jp) {
        String methodName = jp.getSignature().getName();
        Object retVal = null;
        if (methodName.startsWith("doSt")) {
            throw new RuntimeException("stuff totally not appropriate");
        }else {
           retVal= jp.proceed();
        }
        System.out.println("You are using deprecated methods!!! "+methodName);
        return retVal;
    }*/
}








