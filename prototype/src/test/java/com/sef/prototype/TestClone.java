package com.sef.prototype;

import org.junit.Test;

/**
 * Created by zhangyongjie on 2018/8/16.
 */
public class TestClone {

    @Test
    public void testPlan() throws Exception {
        Plan plan = new Plan();
        plan.name = "plan";
        plan.executors.add("a");
        System.out.println("plan : " + plan.toString());

        // Plan clone = (Plan)plan.clone();
        Plan clone = (Plan)plan.deepClone();
        System.out.println("clone: " + clone.toString());

        System.out.println("-------------------------");

        plan.name = "newplan";
        plan.executors.add("b");
        System.out.println("new plan : " + plan.toString());
        System.out.println("after modify plan clone:" + clone.toString());

    }
}
