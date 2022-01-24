package com.wzz.delayretry;

import com.wzz.delayretry.annotations.DelayRetry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: delay-retry
 * @description:
 * @author: wangzz
 * @create: 2022-01-21 18:37
 */
@RestController
public class TestController {


    @GetMapping("/ok")
    @DelayRetry
    public  String  test(){
        System.out.println("ok");
        throw new RuntimeException("异常");
    }


}
