package com.enn.chainOfResponsibility;

/**
 * Created by enn on 2018/5/1.
 * design pattern:Chain of responsibility
 *
 * the chain of responsibility pattern creates a chain of receiver objects for a request.
 * This pattern decouples sender and receiver of a request based on type of request.
 * This pattern comes under behavioral patterns.
 * In this pattern, normally each receiver contains reference to another receiver.
 * If one object cannot handle the request then it passes the same to the next receiver
 * and so on.
 */
public abstract class AbstractLogger {
    public static final int INFO = 1;

    public static final int DEBUG = 2;

    public static final int ERROR = 3;

    protected int level;

    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger logger) {
        this.nextLogger = logger;
    }

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    abstract protected void write(String message);
}
