package com.enn.chainOfResponsibility;


import com.enn.chainOfResponsibility.AbstractLogger;
import com.enn.chainOfResponsibility.FileLogger;

/**
 * Created by enn on 2018/5/1.
 */
public class LoggerTest {

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO,
                "This is an information.");

        loggerChain.logMessage(AbstractLogger.DEBUG,
                "This is an debug level information.");

        loggerChain.logMessage(AbstractLogger.ERROR,
                "This is an error information.");
    }

    private static AbstractLogger getChainOfLoggers() {

        AbstractLogger infoLogger = new ConsoleLogger(AbstractLogger.INFO);
        AbstractLogger debugLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);

        errorLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(infoLogger);
        return errorLogger;
    }
}
