package org.chen.arch.core.request;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LimitAspect {


    @Pointcut("execution(* org.chen.arch.controller..*.*(..))")
    public void execute(){}

    @Before("execute() && @annotation(limit)")
    public void limitExecute(JoinPoint point, Limit limit){
        System.out.println("before-------------");
        System.out.println("limit size =" + limit.size());
    }


    @After("execute()")
    public void afterLimit(){
        System.out.println("after-----------");
    }


    @Around("execution(* org.chen.arch.controller..*.*(..)) && @annotation(org.chen.arch.core.request.Limit)")
    public Object aroundLimit(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("begin------------");
        Object obj = joinPoint.proceed();
        System.out.println(obj.toString());
        return obj;
    }

}
