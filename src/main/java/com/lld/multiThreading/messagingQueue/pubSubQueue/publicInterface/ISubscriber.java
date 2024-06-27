package com.lld.multiThreading.messagingQueue.pubSubQueue.publicInterface;

import com.lld.multiThreading.messagingQueue.pubSubQueue.model.Message;

public interface ISubscriber {
    String getId();
    void consume(Message message) throws InterruptedException;
}
