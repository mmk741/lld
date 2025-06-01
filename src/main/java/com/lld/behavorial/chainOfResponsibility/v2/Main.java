package com.lld.behavorial.chainOfResponsibility.v2;

public class Main {

    public static void main(String args[]) {

        //we pass next log processor while creating object
        LogProcessor logObjectHead = new InfoLogProcessor();
        LogProcessor logObject = logObjectHead
                .setNext(new DebugLogProcessor())
                .setNext(new ErrorLogProcessor());



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

        logObjectHead.log(LogProcessor.ERROR, "exception happens");
        logObjectHead.log(LogProcessor.DEBUG, "need to debug this ");
        logObjectHead.log(LogProcessor.INFO, "just for info ");

    }
}
