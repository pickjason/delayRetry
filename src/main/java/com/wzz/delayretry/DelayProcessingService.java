package com.wzz.delayretry;

import com.wzz.delayretry.entity.DelayTask;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @program: delay-retry
 * @description:
 * @author: wangzz
 * @create: 2022-01-21 14:41
 */
@Component
public interface DelayProcessingService {

    /**
     * @return
     */
    Future submit();


    /**
     *
     */
    void execute(DelayTask delayTask);






}
