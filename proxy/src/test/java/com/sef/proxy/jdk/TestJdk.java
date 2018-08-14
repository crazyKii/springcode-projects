package com.sef.proxy.jdk;

import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by zhangyongjie on 2018/8/14.
 */
public class TestJdk {

    @Test
    public void testJdkProxy() throws Exception {

        Subject proxy = (Subject) new SubjectProxyHandler().getInstance(new RealSubject());
        // com.sun.proxy.$Proxy4
        // 代理类对象名字
        System.out.println(proxy.getClass());
        //通过代理类调用方法
        proxy.rent();

        // 获取字节码
        byte[] data = ProxyGenerator.generateProxyClass(proxy.getClass().getName(), new Class[]{Subject.class});
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\$Proxy4.class");
        fos.write(data);
        fos.close();

    }

}
