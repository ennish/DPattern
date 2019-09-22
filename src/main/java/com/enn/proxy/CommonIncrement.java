package com.enn.proxy;

/**
 * @author hacker
 */
public class CommonIncrement implements Incrementable {
    private int count = 0;
    private int delta = 1;

    public CommonIncrement() {
    }

    public CommonIncrement(int delta) {
        this.delta = delta;
    }

    @Override
    public void increment() {
        count = count + delta;
    }

    public int getCount() {
        return this.count;
    }
}
