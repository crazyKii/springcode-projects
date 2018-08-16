package com.sef.strategy;

import org.junit.Test;

/**
 * Created by zhangyongjie on 2018/8/16.
 */
public class TestStrategy {

    @Test
    public void testPrice(){
        Player player = new Player();
        player.buy(10000D);
        System.out.println("原始价格：" + player.totalAmount);
        System.out.println("玩家实际支付：" + player.calLastAmount());
        player.buy(20000D);
        System.out.println("原始价格：" + player.totalAmount);
        System.out.println("玩家实际支付：" + player.calLastAmount());
        player.buy(30000D);
        System.out.println("原始价格：" + player.totalAmount);
        System.out.println("玩家实际支付：" + player.calLastAmount());
    }
}
