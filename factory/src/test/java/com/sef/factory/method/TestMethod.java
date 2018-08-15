package com.sef.factory.method;

import org.junit.Test;

/**
 * Created by zhangyongjie on 2018/8/15.
 */
public class TestMethod {

    @Test
    public void testMethod() {
        FactoryBMW factoryBMW320 = new FactoryBMW320();
        BMW320 bmw320 = (BMW320) factoryBMW320.createBMW();

        FactoryBMW factoryBMW523 = new FactoryBMW523();
        BMW523 bmw523 = (BMW523) factoryBMW523.createBMW();
    }

}
