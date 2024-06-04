package com.lld.behavorial.command;

public class TurnOffAcCommand implements ICommand{
    AirConditioner ac;

    public TurnOffAcCommand(AirConditioner ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.turnOffAc();

    }

    @Override
    public void undo() {
        ac.turnOnAc();
    }
}
