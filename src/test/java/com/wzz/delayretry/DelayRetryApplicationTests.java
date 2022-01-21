package com.wzz.delayretry;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class DelayRetryApplicationTests {

    @Autowired
    private HashedWheelTimer hashedWheelTimer;

    @Test
    void contextLoads() {
        System.out.println(LocalDateTime.now().toString());
        hashedWheelTimer.newTimeout(new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                System.out.println("你好");
            }
        },1L, TimeUnit.MINUTES);
    }

}
