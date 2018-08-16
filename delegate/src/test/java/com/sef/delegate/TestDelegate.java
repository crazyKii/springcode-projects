package com.sef.delegate;

import org.junit.Test;

public class TestDelegate {

    @Test
    public void testDel(){
        Leader leader = new Leader(new TargetA());
        leader.doing();
    }

}
