package com.bupt.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * @Author czgggggggg
 * @Date 2021/10/13
 * @Description
 */
@Component
public class CustomAdvice implements MethodInterceptor {
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("before...");
        Object proceed = methodInvocation.proceed();
        System.out.println("after");
        return proceed;
    }
}
