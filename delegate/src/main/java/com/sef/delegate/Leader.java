package com.sef.delegate;

public class Leader implements ITarget{

    private ITarget target;

    public Leader(ITarget target) {
        this.target = target;
    }

    public void doing() {
        target.doing();
    }
}
