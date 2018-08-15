package com.sef.proxy.cglib;

import org.junit.Test;

/**
 * Created by zhangyongjie on 2018/8/15.
 */
public class TestCglib {

    @Test
    public void testCglibProxy(){
        RealSubject  proxy = (RealSubject ) new SubjectProxy().getInstance(new RealSubject());
        proxy.rent();
        System.out.println("---------------------------------");
        System.out.println(proxy.getClass().getName());
    }
}
