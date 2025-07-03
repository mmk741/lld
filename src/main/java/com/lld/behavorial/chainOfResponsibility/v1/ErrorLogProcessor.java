package com.lld.behavorial.chainOfResponsibility.v1;

public class ErrorLogProcessor extends LogProcessor{

    ErrorLogProcessor(LogProcessor nexLogProcessor){
        super(nexLogProcessor);
    }

    public void log(int logLevel,String message){

        if(logLevel == ERROR) {
            System.out.println("ERROR: " + message);
        } else{

            nextLoggerProcessor.log(logLevel, message);
        }

    }
}
