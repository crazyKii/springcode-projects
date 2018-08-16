package com.sef.singleton.three;

/**
 * Created by zhangyongjie on 2018/8/15.
 */
public class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    public static synchronized Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
