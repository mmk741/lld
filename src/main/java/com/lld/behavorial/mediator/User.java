package com.lld.behavorial.mediator;

public abstract class User {
    protected IchatMediator mediator;
    protected String name;

    public User(IchatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void send(String message);
    public abstract void receive(String message);
}
