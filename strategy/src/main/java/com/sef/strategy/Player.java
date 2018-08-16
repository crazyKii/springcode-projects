package com.sef.strategy;

/**
 * Created by zhangyongjie on 2018/8/16.
 */
public class Player {
    //客户在鹅厂消费的总额
    public Double totalAmount = 0D;
    //客户单次消费金额
    public Double amount = 0D;
    // 每个客户都有一个计算价格的策略，初始都是普通计算，即原
    public PriceStrategy calPrice = new Orgnic();

    public void buy(Double amount){

        this.amount = amount;
        this.totalAmount += amount;
        if(totalAmount > 20000){
            calPrice = new VIP2();
        }
        else if(totalAmount > 10000){
            calPrice = new VIP1();
        }
    }

    // 执行策略
    public Double calLastAmount(){
        return calPrice.calPrice(this.totalAmount);
    }
}
