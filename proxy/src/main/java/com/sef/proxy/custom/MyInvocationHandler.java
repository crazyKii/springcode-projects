package com.sef.proxy.custom;

import java.lang.reflect.Method;

/**
 * Created by zhangyongjie on 2018/8/14.
 */
public interface MyInvocationHandler {
    Object invoke(Object proxy, Method method, Object[] args) throws  Throwable;
}
