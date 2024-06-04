package com.lld.behavorial.chainOfResponsibility;

public class Main {

    public static void main(String args[]) {

        //we pass next log processor while creating object
        LogProcessor logObject = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        logObject.log(LogProcessor.ERROR, "exception happens");
        logObject.log(LogProcessor.DEBUG, "need to debug this ");
        logObject.log(LogProcessor.INFO, "just for info ");

    }
}
