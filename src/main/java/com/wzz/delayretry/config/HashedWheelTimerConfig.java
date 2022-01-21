package com.wzz.delayretry.config;

import com.wzz.delayretry.factory.DelayRetryThreadFactory;
import io.netty.util.HashedWheelTimer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @program: delay-retry
 * @description:
 * @author: wangzz
 * @create: 2022-01-21 14:57
 */
@Configuration
@ConfigurationProperties(prefix = "delay-retry")
public class HashedWheelTimerConfig {

    private final ThreadFactory threadFactory = new DelayRetryThreadFactory("delayRetry", false);

    private long tickDuration;

    private int ticksPerWheel;

    private String unit = "SECONDS";

    private boolean leakDetection = true;

    private long maxPendingTimeouts;


    @Bean
    public HashedWheelTimer hashedWheelTimer() {
        return new HashedWheelTimer(threadFactory, tickDuration, TimeUnit.valueOf(unit), ticksPerWheel, leakDetection, maxPendingTimeouts);
    }


    public void setTickDuration(long tickDuration) {
        this.tickDuration = tickDuration;
    }


    public void setTicksPerWheel(int ticksPerWheel) {
        this.ticksPerWheel = ticksPerWheel;
    }

    public void setMaxPendingTimeouts(long maxPendingTimeouts) {
        this.maxPendingTimeouts = maxPendingTimeouts;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
