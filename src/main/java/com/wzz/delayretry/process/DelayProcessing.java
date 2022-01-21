package com.wzz.delayretry.process;

import com.wzz.delayretry.DelayProcessingService;
import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @program: delay-retry
 * @description:
 * @author: wangzz
 * @create: 2022-01-21 14:36
 */
@Service
public class DelayProcessing implements DelayProcessingService {

   @Autowired
   HashedWheelTimer hashedWheelTimer;

    @Override
    public Future submit() {
        return null;
    }

    @Override
    public void execute() {
        System.out.println(LocalDateTime.now().toString());
        hashedWheelTimer.newTimeout(new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                System.out.println("你好");
            }
        },1L, TimeUnit.MINUTES);
    }


}
