package com.sef.factory.simple;

import org.junit.Test;

/**
 * Created by zhangyongjie on 2018/8/15.
 */
public class TestSimpleFactory {

    @Test
    public void testSimple() {
        Factory factory = new Factory();
        BMW bmw320 = factory.createBMW(320);
        BMW bmw523 = factory.createBMW(523);
    }

}
