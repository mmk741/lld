package com.lld.behavorial.chainOfResponsibility.v2;

public abstract class LogProcessor {

    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    LogProcessor nextLoggerProcessor;

   public LogProcessor setNext(LogProcessor nextLoggerProcessor) {
       this.nextLoggerProcessor = nextLoggerProcessor;
       return nextLoggerProcessor; //for  fluent chaining in v1 we have contructor chaining ie not good
   }

    abstract public void log(int logLevel, String message);
}
