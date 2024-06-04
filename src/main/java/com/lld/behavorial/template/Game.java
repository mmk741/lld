package com.lld.behavorial.template;

public abstract class Game {
    // Template method
    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }

    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();
}
