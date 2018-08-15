package com.sef.proxy.custom;

import com.sef.proxy.jdk.RealSubject;
import com.sef.proxy.jdk.Subject;
import org.junit.Test;

/**
 * Created by zhangyongjie on 2018/8/14.
 */
public class TestCustomProxy {

    @Test
    public void testProxy(){

        Subject proxy = (Subject)new SubjectProxyHandler().getInstance(new RealSubject());
        System.out.println(proxy.getClass().getName());
        proxy.rent();

    }
}
