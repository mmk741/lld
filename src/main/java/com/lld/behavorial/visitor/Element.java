package com.lld.behavorial.visitor;

public interface Element {
    void accept(Visitor visitor);
}
