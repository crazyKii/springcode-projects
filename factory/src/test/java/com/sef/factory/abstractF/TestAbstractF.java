package com.sef.factory.abstractF;

import org.junit.Test;

/**
 * Created by zhangyongjie on 2018/8/15.
 */
public class TestAbstractF {

    @Test
    public void testAbstract() {
        AbstractFactory factory = new FactoryBMW320();
        EngineA engineA = (EngineA)factory.createEngine();
        AirconditionA airconditionA = (AirconditionA)factory.createAircondition();
    }

}
