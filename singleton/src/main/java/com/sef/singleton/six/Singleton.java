package com.sef.singleton.six;

public class Singleton {

    private static boolean initialized = false;

    private Singleton(){
        synchronized (Singleton.class){
            if(initialized){
                throw new RuntimeException("单例已被破坏");
            }else{
                initialized = !initialized;
            }
        }
    }

    static class SingletonHandler{
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonHandler.instance;
    }
}
