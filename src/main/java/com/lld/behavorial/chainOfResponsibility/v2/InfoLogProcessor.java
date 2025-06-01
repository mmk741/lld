package com.lld.behavorial.chainOfResponsibility.v2;

public class InfoLogProcessor extends LogProcessor{



    public void log(int logLevel,String message){

        if(logLevel == INFO) {
            System.out.println("INFO: " + message);
        } else if (nextLoggerProcessor!=null) {

            nextLoggerProcessor.log(logLevel, message);
        }

    }
}
