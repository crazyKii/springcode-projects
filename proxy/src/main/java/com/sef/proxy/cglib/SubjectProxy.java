package com.sef.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by zhangyongjie on 2018/8/14.
 */
public class SubjectProxy implements MethodInterceptor {

    private Object target;

    public Object getInstance(Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        System.out.println("before rent house");
        System.out.println("method : " + method);
        System.out.println("methodProxy: " + methodProxy.getSignature());

        // 被代理对象
        methodProxy.invokeSuper(o,args);

        System.out.println("after rent house");

        return null;
    }

}
