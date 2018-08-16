package com.sef.singleton.seven;

import java.io.Serializable;

public class Singleton implements Serializable {

    private static boolean initialized = false;

    private Singleton(){
        synchronized (Singleton.class){
            if(initialized){
                throw new RuntimeException("单例已被破坏");
            }else {
                initialized = !initialized;
            }
        }
    }

    private static class SingletonHandler{
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonHandler.instance;
    }

    private Object readResolve(){
        return getInstance();
    }
}
