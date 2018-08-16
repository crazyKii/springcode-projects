package com.sef.strategy;

/**
 * Created by zhangyongjie on 2018/8/16.
 */
public class VIP1 implements PriceStrategy{

    public Double calPrice(Double orgnicPrice) {
        return orgnicPrice*0.9;
    }
}
