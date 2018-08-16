package com.sef.singleton.five;

/**
 * Created by zhangyongjie on 2018/8/15.
 */
public class Singleton {

    private Singleton() {
    }

    static class SingletonHolder{
        private static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonHolder.instance;
    }
}
