package com.lld.behavorial.chainOfResponsibility.v2;

public class ErrorLogProcessor extends LogProcessor{



    public void log(int logLevel,String message){

        if(logLevel == ERROR) {
            System.out.println("ERROR: " + message);
        } else if (nextLoggerProcessor!=null){

            nextLoggerProcessor.log(logLevel, message);
        }

    }
}
