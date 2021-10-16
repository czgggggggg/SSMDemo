package com.bupt.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author czgggggggg
 * @Date 2021/10/16
 * @Description
 */
@Component
@Aspect
public class CustomAspect {
    @Pointcut("@annotation(com.bupt.anno.CountTime)")
    public void mypointcut(){}

    @Around(value = "mypointcut()")
    public Object myaround(ProceedingJoinPoint proceedingJoinPoint){

        Object proceed = null;

        try {
            long start = System.currentTimeMillis();
            proceed = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            long cost = end - start;
            System.out.println(proceedingJoinPoint.getSignature().getName() + "方法消耗的时间为：" + cost);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return proceed;
    }
}
