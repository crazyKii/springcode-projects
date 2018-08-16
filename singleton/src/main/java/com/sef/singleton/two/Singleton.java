package com.sef.singleton.two;

/**
 * Created by zhangyongjie on 2018/8/15.
 */
public class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
