package com.wzz.delayretry;

import java.util.concurrent.Future;

/**
 * @program: delay-retry
 * @description:
 * @author: wangzz
 * @create: 2022-01-21 14:41
 */
public interface DelayProcessingService {

    /**
     * @return
     */
    Future submit();


    /**
     *
     */
    void execute();


}
