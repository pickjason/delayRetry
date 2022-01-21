package com.wzz.delayretry.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @program: delay-retry
 * @description:
 * @author: wangzz
 * @create: 2022-01-21 16:08
 */
@Aspect
@Component
public class DelayRetryAspect {

   @Pointcut("@annotation(com.wzz.delayretry.annotations.DelayRetry)")
    public void DelayPoint(){

   }



   @Before("DelayPoint()")
    public void submitTask(JoinPoint joinPoint){
       Object[] args = joinPoint.getArgs();

       Class<? extends JoinPoint> aClass = joinPoint.getClass();

       Object target = joinPoint.getTarget();

       MethodSignature signature = (MethodSignature) joinPoint.getSignature();

   }

}
