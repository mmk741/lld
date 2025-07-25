package com.lld.behavorial.chainOfResponsibility.v1;

public class DebugLogProcessor extends LogProcessor{

    DebugLogProcessor(LogProcessor nexLogProcessor){
        super(nexLogProcessor);
    }

    public void log(int logLevel,String message){

        if(logLevel == DEBUG) {
            System.out.println("DEBUG: " + message);
        } else{

            nextLoggerProcessor.log(logLevel, message);
        }

    }
}
