package com.enn.chainOfResponsibility;

/**
 * Created by enn on 2018/5/1.
 */
public class FileLogger extends AbstractLogger {


    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("FILE log :" + message +"level:"+this.level);
    }
}
