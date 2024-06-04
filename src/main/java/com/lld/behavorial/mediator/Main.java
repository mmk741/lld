package com.lld.behavorial.mediator;

public class Main {
    public static void main(String[] args) {
        IchatMediator mediator = new ChatMediatorImpl();

        User user1 = new UserImpl(mediator, "Alice");
        User user2 = new UserImpl(mediator, "Bob");
        User user3 = new UserImpl(mediator, "Charlie");
        User user4 = new UserImpl(mediator, "Dave");

        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        mediator.addUser(user4);

        user1.send("Hi everyone!");
    }
}
