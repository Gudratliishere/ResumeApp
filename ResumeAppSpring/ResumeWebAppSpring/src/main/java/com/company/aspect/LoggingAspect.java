package com.company.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect
{
    @Before("execution(* com.company.controller.UserController.loginPost())")
    public void logBefore (JoinPoint joinPoint)
    {
        System.out.println("logBefore() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("*******************");
    }

    @After("execution(* com.company.controller.UserController.loginPost())")
    public void logAfter (JoinPoint joinPoint)
    {
        System.out.println("logAfter() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("*******************");
    }

    @AfterReturning(
            pointcut = "execution(* com.company.controller.UserController.loginPost())",
            returning = "result")
    public void logAfterReturning (JoinPoint joinPoint, Object result)
    {
        System.out.println("logAfterReturning() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("Method returned value is " + result);
        System.out.println("*******************");
    }

    @AfterThrowing(
            pointcut = "execution(* com.company.controller.UserController.loginPost())",
            throwing = "error")
    public void logAfterThrowing (JoinPoint joinPoint, Throwable error)
    {
        System.out.println("logAfterThrowing() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("Exception: " + error);
        System.out.println("*******************");
    }

    @Around("execution(* com.company.controller.UserController.loginPost())")
    public Object logAround (ProceedingJoinPoint joinPoint) throws Throwable
    {
        System.out.println("logAfterThrowing() is running!");
        System.out.println("hijacked method: " + joinPoint.getSignature().getName());
        System.out.println("hijacked arguments: " + Arrays.asList(joinPoint.getArgs()));

        System.out.println("Around before is running!");
        Object object = joinPoint.proceed();
        System.out.println("Around after is running!");

        System.out.println("*******************");

        return object;
    }
}
