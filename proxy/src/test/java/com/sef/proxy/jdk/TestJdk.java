package com.sef.proxy.jdk;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by zhangyongjie on 2018/8/14.
 */
public class TestJdk {

    @Test
    public void testJdkProxy() {
        Subject realSubject = new RealSubject();

        InvocationHandler handler = new SubjectProxy(realSubject);

        Subject proxy = (Subject) Proxy.newProxyInstance(
                handler.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(),
                handler
        );

        // com.sun.proxy.$Proxy4
        // 代理类对象名字
        System.out.println(proxy.getClass().getName());

        //通过代理类调用方法
        proxy.rent();
    }

}
