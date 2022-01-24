package com.wzz.delayretry;

import com.wzz.delayretry.entity.DelayTask;

/**
 * @program: delay-retry
 * @description:
 * @author: wangzz
 * @create: 2022-01-24 16:27
 */
public interface RetryService {



    void retryExecute(DelayTask delayTask);


    void recover(DelayTask delayTask);

}
