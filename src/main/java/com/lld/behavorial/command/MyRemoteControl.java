package com.lld.behavorial.command;

import java.util.Stack;

public class MyRemoteControl {

    //for undo operation
    Stack<ICommand> acCommandStack=new Stack<>();

    //Invoker has a command
    ICommand command;

    public MyRemoteControl() {
    }

    //setting command here and not running it instantly we can run on demand basis
    public void setCommand(ICommand command){
        this.command=command;
    }

    //running the command
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
