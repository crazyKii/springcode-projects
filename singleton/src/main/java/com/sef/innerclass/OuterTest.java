package com.sef.innerclass;

import org.junit.Test;

/**
 * Created by zhangyongjie on 2018/8/15.
 */
public class OuterTest {

    static {
        System.out.println("load outer class...");
    }

    static class InnerClass{
        static {
            System.out.println("load static inner class...");
        }

        static void innerMethod(){
            System.out.println("static inner method...");
        }
    }

    @Test
    public void test(){
        OuterTest outerTest = new OuterTest();
        System.out.println("===================完成加载======================");
        InnerClass.innerMethod();
    }

}
