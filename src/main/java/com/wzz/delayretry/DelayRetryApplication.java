package com.wzz.delayretry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DelayRetryApplication {
    @Autowired
   static DelayProcessingService delayProcessingService;

    public static void main(String[] args) {
        SpringApplication.run(DelayRetryApplication.class, args);


    }



}
