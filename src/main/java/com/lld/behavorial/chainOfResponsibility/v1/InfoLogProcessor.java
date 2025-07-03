package com.lld.behavorial.chainOfResponsibility.v1;

public class InfoLogProcessor extends LogProcessor{

    InfoLogProcessor(LogProcessor nexLogProcessor){
        super(nexLogProcessor);
    }

    public void log(int logLevel,String message){

        if(logLevel == INFO) {
            System.out.println("INFO: " + message);
        } else{

            nextLoggerProcessor.log(logLevel, message);
        }

    }
}
