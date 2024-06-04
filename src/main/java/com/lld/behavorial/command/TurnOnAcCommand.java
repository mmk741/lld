package com.lld.behavorial.command;

public class TurnOnAcCommand implements ICommand {

    AirConditioner ac;

    public TurnOnAcCommand(AirConditioner ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.turnOnAc();

    }

    @Override
    public void undo() {
        ac.turnOffAc();
    }
}
