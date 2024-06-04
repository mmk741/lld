package com.lld.behavorial.command;

import java.util.Stack;

public class MyRemoteControl {
    Stack<ICommand> acCommandStack=new Stack<>();
    ICommand command;

    public MyRemoteControl() {
    }

    public void setCommand(ICommand command){
        this.command=command;
    }

    public  void pressButton(){
        command.execute();
        acCommandStack.push(command);
    }

    public  void undo(){
        if(!acCommandStack.isEmpty()){
            ICommand lastCommand=acCommandStack.pop();
            lastCommand.undo();
        }
    }
}
