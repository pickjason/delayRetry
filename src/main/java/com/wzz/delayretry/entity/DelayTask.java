package com.wzz.delayretry.entity;

import org.aspectj.lang.ProceedingJoinPoint;

import java.util.concurrent.TimeUnit;

/**
 * @program: delay-retry
 * @description:
 * @author: wangzz
 * @create: 2022-01-24 13:18
 */
public class DelayTask {

  private   ProceedingJoinPoint proceedingJoinPoint;

  private Long tick;

  private TimeUnit  timeUnit;

  private boolean isRetry;

  private Integer retryTimes = 0;

  private Long retryTimeInterval;

  private TimeUnit retryUnit;


  private Integer maxRetryTimes;

  private DelayTask(){

  }

  public static DelayTask createTaskNotRetry(ProceedingJoinPoint proceedingJoinPoint ,Long tick , TimeUnit timeUnit){
      DelayTask delayTask = new DelayTask();
      delayTask.setTick(tick);
      delayTask.setTimeUnit(timeUnit);
      delayTask.setProceedingJoinPoint(proceedingJoinPoint);
      delayTask.setRetry(false);
      return delayTask;
  }


  public static DelayTask createTaskNeedRetry(ProceedingJoinPoint proceedingJoinPoint ,Long tick , TimeUnit timeUnit,Integer maxRetryTimes,
                                              Long retryTimeInterval,TimeUnit retryUnit){
      DelayTask delayTask = new DelayTask();
      delayTask.setTick(tick);
      delayTask.setTimeUnit(timeUnit);
      delayTask.setProceedingJoinPoint(proceedingJoinPoint);
      delayTask.setRetry(true);
      delayTask.setRetryUnit(retryUnit);
      delayTask.setRetryTimeInterval(retryTimeInterval);
      delayTask.setMaxRetryTimes(maxRetryTimes);
      return delayTask;
  }


    public ProceedingJoinPoint getProceedingJoinPoint() {
        return proceedingJoinPoint;
    }

    public void setProceedingJoinPoint(ProceedingJoinPoint proceedingJoinPoint) {
        this.proceedingJoinPoint = proceedingJoinPoint;
    }

    public Long getTick() {
        return tick;
    }

    public void setTick(Long tick) {
        this.tick = tick;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public boolean isRetry() {
        return isRetry;
    }

    public void setRetry(boolean retry) {
        isRetry = retry;
    }

    public Integer getRetryTimes() {
        return retryTimes;
    }

    public void setRetryTimes(Integer retryTimes) {
        this.retryTimes = retryTimes;
    }

    public Long getRetryTimeInterval() {
        return retryTimeInterval;
    }

    public void setRetryTimeInterval(Long retryTimeInterval) {
        this.retryTimeInterval = retryTimeInterval;
    }

    public TimeUnit getRetryUnit() {
        return retryUnit;
    }

    public void setRetryUnit(TimeUnit retryUnit) {
        this.retryUnit = retryUnit;
    }

    public Integer getMaxRetryTimes() {
        return maxRetryTimes;
    }

    public void setMaxRetryTimes(Integer maxRetryTimes) {
        this.maxRetryTimes = maxRetryTimes;
    }
}
