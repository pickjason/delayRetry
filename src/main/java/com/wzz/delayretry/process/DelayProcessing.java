package com.wzz.delayretry.process;

import com.wzz.delayretry.DelayProcessingService;
import com.wzz.delayretry.RetryService;
import com.wzz.delayretry.entity.DelayTask;
import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @program: delay-retry
 * @description:
 * @author: wangzz
 * @create: 2022-01-21 14:36
 */
@Service
public class DelayProcessing implements DelayProcessingService ,RetryService {

    @Autowired
    private HashedWheelTimer hashedWheelTimer;

    @Override
    public Future submit() {
        return null;
    }

    @Override
    public void execute(DelayTask delayTask) {
        hashedWheelTimer.newTimeout(new TimerTask() {
            boolean errorFlag = false;
            @Override
            public void run(Timeout timeout) throws Exception {
                try {
                    delayTask.getProceedingJoinPoint().proceed();
                } catch (Throwable throwable) {
                  errorFlag=true;
                }finally {
                    if(errorFlag){
                        retryExecute(delayTask);
                    }
                }
            }
        },delayTask.getTick(),delayTask.getTimeUnit());
    }


    @Override
    public void retryExecute(DelayTask delayTask) {
        if (delayTask.isRetry()&&delayTask.getRetryTimes()<delayTask.getMaxRetryTimes()) {
            delayTask.setRetryTimes(delayTask.getRetryTimes()+1);
            delayTask.setTick(delayTask.getRetryTimeInterval());
            delayTask.setTimeUnit(delayTask.getRetryUnit());
            execute(delayTask);
        }
    }
}
