package com.lld.behavorial.mediator;

public interface IchatMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}
