package com.sef.proxy.jdk;

/**
 * Created by zhangyongjie on 2018/8/14.
 */
public class RealSubject implements Subject{

    public void rent() {
        System.out.println("I want to rent my house");
    }
}
