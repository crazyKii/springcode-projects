package com.sef.singleton.one;

/**
 * Created by zhangyongjie on 2018/8/15.
 */
public class Singleton {

    // 1. 保证对象只有一个
    private static Singleton instance = new Singleton();

    // 2. 构造方法为private
    private Singleton(){}

    // 3. 通过静态方法返回单例对象
    public static Singleton getInstance(){
        return instance;
    }

}
