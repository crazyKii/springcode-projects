package com.sef.singleton.six;

import org.junit.Test;

import java.lang.reflect.Constructor;

public class TestV3 {

    @Test
    public void testReflesh(){
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = null;

        try{
            Class<Singleton> clazz = Singleton.class;
            Constructor<Singleton> cons = clazz.getDeclaredConstructor();
            cons.setAccessible(true);
            instance2 = cons.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Instance 1 hash: " + instance.hashCode());
        System.out.println("Instance 2 hash: " + instance2.hashCode());
    }
}
/*
Instance 1 hash: 849460928
Instance 2 hash: 580024961
 */