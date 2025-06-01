package com.lld.behavorial.chainOfResponsibility.v1;

public class Main {

    public static void main(String args[]) {

        //we pass next log processor while creating object
        LogProcessor logObject = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));


//        Execution Steps:
//        InfoLogProcessor.log() is called.
//
//        Checks logLevel == INFO → false, passes to next
//
//        DebugLogProcessor.log() is called.
//
//        Checks logLevel == DEBUG → false, passes to next
//
//        ErrorLogProcessor.log() is called.
//
//        Checks logLevel == ERROR → true, prints:

        logObject.log(LogProcessor.ERROR, "exception happens");
        logObject.log(LogProcessor.DEBUG, "need to debug this ");
        logObject.log(LogProcessor.INFO, "just for info ");

    }
}
