package com.sef.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by zhangyongjie on 2018/8/14.
 */
public class SubjectProxy implements InvocationHandler {

    // 被代理的对象
    private Object subject;

    // 被代理对象资料
    public SubjectProxy(Object subject) {
        this.subject = subject;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before rent house");
        System.out.println("Method: " + method);

        // 调用被代理对象方法
        method.invoke(subject, args);

        System.out.println("after rent house");
        return null;
    }
}
