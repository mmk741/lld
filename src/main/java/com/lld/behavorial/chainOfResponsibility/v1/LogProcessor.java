package com.lld.behavorial.chainOfResponsibility.v1;

public abstract class LogProcessor {

    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    LogProcessor nextLoggerProcessor;

    LogProcessor(LogProcessor loggerProcessor) {

        this.nextLoggerProcessor = loggerProcessor;

    }

    public abstract void log(int logLevel, String message);
//    {
//
//        if (nextLoggerProcessor != null) {
//            nextLoggerProcessor.log(logLevel, message);
//        }
//    }
}
