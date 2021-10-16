package com.bupt.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author czgggggggg
 * @Date 2021/10/14
 * @Description 切面类中的方法：就是做什么事情
 *              时间：由我们配置
 */
@Component
@Aspect
public class CustomAspect {
//    public void mybefore(){
//        System.out.println("before...");
//    }

    @Pointcut("execution(* com..*(*))")
    public void mypointcut(){}

//    @Before("execution(* com..*(*))")
    @Before("mypointcut()")
    public void mybefore(JoinPoint joinPoint){
        System.out.println("before...");

        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("method = " + name);

        Object aThis = joinPoint.getThis();
        Object target = joinPoint.getTarget();
        Object[] args = joinPoint.getArgs();
        System.out.println("joinPoint.getThis() = " + aThis);
        System.out.println("joinPoint.getTarget() = " + target);
        System.out.println("joinPoint.getArgs() = " + Arrays.asList(args));
    }

//    @After("execution(* com..*(*))")
    @After("mypointcut()")
    public void myafter(){
        System.out.println("after...");
    }

//    @Around("execution(* com..*(*))")
    @Around("mypointcut()")
    public Object myaround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around before...");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("around after...");
        return proceed;
    }

//    @AfterReturning(value = "execution(* com..*(*))",returning = "object")
    @AfterReturning(value = "mypointcut()", returning = "object")
    public void myafterReturning(Object object){
        System.out.println("after-returning object = " + object);
    }

//    @AfterThrowing(value = "execution(* com..*(*))",throwing = "throwable")
    @AfterThrowing(value = "mypointcut()",throwing = "throwable")
    public void myafterThrowing(Throwable throwable){
        System.out.println("after-throwing throwable = " + throwable);
    }
}
