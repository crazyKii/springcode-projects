package com.sef.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zhangyongjie on 2018/8/14.
 */
public class SubjectProxyHandler implements InvocationHandler {

    // 被代理的对象
    private Subject target;

    // 被代理对象资料
    public Object getInstance(Subject target){
        this.target = target;
        Class<?> clazz = target.getClass();
        System.out.println("被代理对象的class是: " + clazz);
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before rent house");
        System.out.println("Method: " + method);

        // 调用被代理对象方法
        method.invoke(this.target, args);

        System.out.println("after rent house");
        return null;
    }
}
