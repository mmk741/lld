package com.lld.multiThreading.printOddEvenUsingTwoThread;

import lombok.SneakyThrows;

public class Printer implements Runnable {
    private final int step;
    private final State state;
    private int currentValue;
    private final PrinterType currentPrinterType;
    private final PrinterType nextPrinterType;
    private final int maxValue;


    public Printer( final Integer startValue,  final int step,  final State state,
                    final PrinterType currentPrinterType,  final PrinterType nextPrinterType,
                    Integer maxValue) {
        this.currentValue = startValue;
        this.step = step;
        this.state = state;
        this.currentPrinterType = currentPrinterType;
        this.nextPrinterType = nextPrinterType;
        this.maxValue = maxValue;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (currentValue <= maxValue) {
            synchronized (state) {
                while (this.currentPrinterType != state.getNextToPrint()) {
                    state.wait();
                }
                System.out.println(currentPrinterType.toString() + ": " + currentValue);
                currentValue += step;
                state.setNextToPrint(this.nextPrinterType);
                state.notifyAll();
            }
        }
    }
}
