package com.wzz.delayretry;

import com.wzz.delayretry.annotations.DelayRetry;
import io.netty.util.HashedWheelTimer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DelayRetryApplicationTests {

    @Autowired
    private HashedWheelTimer hashedWheelTimer;

    @Autowired
    private TestController testController;

    @Test
    @DelayRetry
    void contextLoads() {
        testController.test();
    }





}
