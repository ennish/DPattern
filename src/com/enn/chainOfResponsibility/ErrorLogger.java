package com.enn.chainOfResponsibility;

/**
 * Created by enn on 2018/5/1.
 */
public class ErrorLogger extends AbstractLogger {


    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("ERROR log:" + message +"level:"+this.level);
    }
}
