package com.wzz.delayretry.aspect;

import com.wzz.delayretry.DelayProcessingService;
import com.wzz.delayretry.entity.DelayTask;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @program: delay-retry
 * @description:
 * @author: wangzz
 * @create: 2022-01-21 16:08
 */
@Aspect
@Component
public class DelayRetryAspect {

   @Autowired
  private DelayProcessingService delayProcessingService;

   @Pointcut("@annotation(com.wzz.delayretry.annotations.DelayRetry)")
    public void DelayPoint(){

   }

   @Around("DelayPoint()")
    public void submitTask(ProceedingJoinPoint joinPoint) throws Throwable {
      delayProcessingService.execute(DelayTask.createTaskNeedRetry(joinPoint,1L,TimeUnit.MINUTES,2,1L,TimeUnit.SECONDS));
   }

}
