package com.lld.multiThreading.printOddEvenUsingTwoThread;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class State {
    private PrinterType nextToPrint;

    public State( final PrinterType nextToPrint) {
        this.nextToPrint = nextToPrint;
    }
}
