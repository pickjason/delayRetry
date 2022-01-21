package com.wzz.delayretry.entity;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @program: delay-retry
 * @description:
 * @author: wangzz
 * @create: 2022-01-21 17:18
 */
public class DelayTask {

     private Object args [];

     private Class aClass;

     private Method method;




     public void invoke(){
          Constructor[] constructors = aClass.getConstructors();
     }


}
