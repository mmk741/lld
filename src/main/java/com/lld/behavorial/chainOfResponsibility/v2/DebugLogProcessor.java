package com.lld.behavorial.chainOfResponsibility.v2;

public class DebugLogProcessor extends LogProcessor{



    public void log(int logLevel,String message){

        if(logLevel == DEBUG) {
            System.out.println("DEBUG: " + message);
        } else if (nextLoggerProcessor!=null){
            nextLoggerProcessor.log(logLevel, message);
        }

    }
}
