package com.sef.singleton.seven;

import org.junit.Test;

import java.io.*;

public class TestV4 {

    @Test
    public void testV4(){
        Singleton instance = Singleton.getInstance();
        ObjectOutput out = null;

        try {

            out = new ObjectOutputStream(new FileOutputStream("aa.ser"));
            out.writeObject(instance);
            out.close();

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("aa.ser"));
            Object instance2 = in.readObject();
            in.close();

            System.out.println("Instance 1 hashCode = " + instance.hashCode());
            System.out.println("Instance 2 hashCode = " + instance2.hashCode());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
