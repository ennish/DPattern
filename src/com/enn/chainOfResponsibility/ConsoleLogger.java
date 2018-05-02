package com.enn.chainOfResponsibility;

/**
 * Created by enn on 2018/5/1.
 */
public class ConsoleLogger extends AbstractLogger {


    public  ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("INFO log :" + message +"level:"+this.level);
    }
}
